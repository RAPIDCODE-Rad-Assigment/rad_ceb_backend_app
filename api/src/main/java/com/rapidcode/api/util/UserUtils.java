package com.rapidcode.api.util;

import com.rapidcode.api.email.EmailService;
import com.rapidcode.api.email.EmailTemplateName;
import com.rapidcode.api.token.Token;
import com.rapidcode.api.token.TokenRepository;
import com.rapidcode.api.user.User;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Component
public class UserUtils {

    @Value("${application.security.mailing.frontend.activation-url}")
    private String activationUrl;

    private final TokenRepository tokenRepository;
    private final EmailService emailService;

    public UserUtils(TokenRepository tokenRepository, EmailService emailService) {
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }

    public String generateAndSaveActivationToken(User user) {
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    public String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }

    public void sendValidationEmail(User user, String token) throws MessagingException {
        emailService.sendEmail(
                user.getEmail(),
                user.getUsersName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                token,
                "Account activation"
        );
    }

    public void sendDeactivatedValidationEmail(User user, String link) throws MessagingException {
        var token =generateAndSaveActivationToken(user);
        emailService.sendAccountDeactivationEmail(
                user.getEmail(),
                user.getUsersName(),
                "Account deactivation",
                link
        );
    }

    public void sendResetPasswordEmail(User user, String token) {
        try {
            emailService.sendPasswordResetEmail(
                    user.getEmail(),
                    user.getUsersName(),
                    EmailTemplateName.FORGOT_PASSWORD,
                    "",
                    token,
                    "Password Reset Request"
            );
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send password reset email", e);
        }
    }

    public void sendAccountCreatedEmail(String email,  String password, String fullName) throws MessagingException {
        emailService.sendAccountCreatedEmail(
                email,
                fullName,
                EmailTemplateName.ACCOUNT_CREATED,
                password,
                "Account created"
        );
    }
}