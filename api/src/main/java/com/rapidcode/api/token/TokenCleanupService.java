package com.rapidcode.api.token;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TokenCleanupService {
    private final TokenRepository tokenRepository;

    // Manually add the constructor
    public TokenCleanupService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Scheduled(fixedRate = 600000) // Cleanup every 1 minute (adjust as needed)
    public void cleanupRevokedTokens() {
        // Perform cleanup logic here
        tokenRepository.deleteRevokedTokens();
    }
}