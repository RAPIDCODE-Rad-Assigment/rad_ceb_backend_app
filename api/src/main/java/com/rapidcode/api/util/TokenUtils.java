package com.rapidcode.api.util;


import com.rapidcode.api.token.TokenRepository;
import com.rapidcode.api.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenUtils {
    private final TokenRepository tokenRepository;

    @Autowired
    public TokenUtils(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}
