package com.rapidcode.api.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rapidcode.api.config.JwtService;
import com.rapidcode.api.email.EmailService;
import com.rapidcode.api.email.EmailTemplateName;
import com.rapidcode.api.handler.DuplicateAdminException;
import com.rapidcode.api.handler.DuplicateEmailException;
import com.rapidcode.api.handler.OperationNotPermittedException;
import com.rapidcode.api.handler.UserNotFoundException;
import com.rapidcode.api.role.RoleRepository;
import com.rapidcode.api.token.TokenRepository;
import com.rapidcode.api.token.TokenType;
import com.rapidcode.api.user.User;
import com.rapidcode.api.token.Token;
import com.rapidcode.api.user.UserRepository;
import com.rapidcode.api.util.TokenUtils;
import com.rapidcode.api.util.UserUtils;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService implements AuthenticationServiceInterface {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private  final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
    private final EmailService emailService;
    private final RoleRepository roleRepository;

    private final UserUtils userUtils;

    private final TokenUtils tokenUtils;

    @Value("${application.security.mailing.frontend.forget_password_url}")
    private  String forgot_password_url;

    @Autowired
    public AuthenticationService(UserRepository repository, TokenRepository tokenRepository,
                                 PasswordEncoder passwordEncoder, JwtService jwtService,
                                 AuthenticationManager authenticationManager,
                                 EmailService emailService, RoleRepository roleRepository, UserUtils userUtils, TokenUtils tokenUtils) {
        this.repository = repository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
        this.roleRepository = roleRepository;
        this.userUtils = userUtils;

        this.tokenUtils = tokenUtils;
    }

    @Override
    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var userRole = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new IllegalStateException("ROLE ADMIN was not initiated"));

        var existingAdmin = repository.findByRoles_Name("ADMIN");
        if (existingAdmin.isPresent()) {
            throw new DuplicateAdminException("An admin user already exists.");
        }

        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateEmailException("Email is already taken");
        }

        try {
            var user = User.builder()
                    .usersName(request.getUsersName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .createdDate(LocalDateTime.now())
                    .address(request.getAddress())
                    .phoneNumber(request.getPhoneNumber())
                    .fullName(request.getFullName())
                    .enabled(true)
                    .accountLocked(false)
                    .roles(List.of(userRole))
                    .build();

            var savedUser = repository.save(user);

            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);

            saveUserToken(savedUser, jwtToken);

            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        } catch (Exception e) {
            // Handle unexpected errors
            throw new RuntimeException("An unexpected error occurred during admin registration", e);
        }
    }

    @Override
    public boolean register(RegisterRequest request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));
        try {
            var user = User.builder()
                    .usersName(request.getUsersName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .accountLocked(false)
                    .createdDate(LocalDateTime.now())
                    .address(request.getAddress())
                    .phoneNumber(request.getPhoneNumber())
                    .fullName(request.getFullName())
                    .enabled(false)
                    .roles(List.of(userRole))
                    .build();
            var savedUser = repository.save(user);
            String newToken = userUtils.generateAndSaveActivationToken(savedUser);
            userUtils.sendValidationEmail(savedUser, newToken);
            return true;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException("Email is already taken");
        } catch (MessagingException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred during registration", e);
        }
    }


    @Override
    @Transactional
    public void activateAccount(String token) throws MessagingException {
        Token savedToken = tokenRepository.findByToken(token)
                // todo exception has to be defined
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            userUtils.sendValidationEmail(savedToken.getUser(), userUtils.generateAndSaveActivationToken(savedToken.getUser()));
            throw new RuntimeException("Activation token has expired. A new token has been send to the same email address");
        }

        var user = repository.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setEnabled(true);
        repository.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }


    @Override
    public void resendActivationCode(String email) throws MessagingException {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));

        if (user.isEnabled()) {
            throw new IllegalStateException("User is already enabled");
        }

        String newToken = userUtils.generateAndSaveActivationToken(user);
        userUtils.sendValidationEmail(user, newToken);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            var user = repository.findByEmail(request.getEmail())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);
            tokenUtils.revokeAllUserTokens(user);
            saveUserToken(user, jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();

    }


    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }



    @Override
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                tokenUtils.revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }


    public void processForgotPassword(String email) throws MessagingException{
        Optional<User> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Generate a reset token
            String token = UUID.randomUUID().toString();
            LocalDateTime expiryTime = LocalDateTime.now().plusHours(1);

            Token resetToken = Token.builder()
                    .token(token)
                    .tokenType(TokenType.PASSWORD_RESET)
                    .user(user)
                    .expiresAt(expiryTime)
                    .createdAt(LocalDateTime.now())
                    .revoked(false)
                    .expired(false)
                    .build();
            tokenRepository.save(resetToken);

            userUtils.sendResetPasswordEmail(user, token);
        }else{
            throw new OperationNotPermittedException("User not found with email: " + email);

        }

    }


    public void resetPassword(String token, String newPassword) {
        Token resetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (resetToken.getTokenType() != TokenType.PASSWORD_RESET) {
            throw new OperationNotPermittedException("Token is not a password reset token");
        }
        if (resetToken.isRevoked()) {
            throw new RuntimeException("Reset token has already been used or revoked");
        }

        if (LocalDateTime.now().isAfter(resetToken.getExpiresAt())) {
            throw new RuntimeException("Reset token has expired");
        }

        User user = repository.findById(resetToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setPassword(passwordEncoder.encode(newPassword));
        repository.save(user);

        // Mark the token as used
        resetToken.setValidatedAt(LocalDateTime.now());
        resetToken.setRevoked(true);
        tokenRepository.save(resetToken);
    }




}

