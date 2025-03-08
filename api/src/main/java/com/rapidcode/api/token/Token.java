package com.rapidcode.api.token;

import com.rapidcode.api.user.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;

    private boolean revoked;

    private boolean expired;

    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime validatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Default constructor
    public Token() {
    }

    // All-args constructor
    public Token(Integer id, String token, TokenType tokenType, boolean revoked, boolean expired,
                 LocalDateTime createdAt, LocalDateTime expiresAt, LocalDateTime validatedAt, User user) {
        this.id = id;
        this.token = token;
        this.tokenType = tokenType;
        this.revoked = revoked;
        this.expired = expired;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.validatedAt = validatedAt;
        this.user = user;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getValidatedAt() {
        return validatedAt;
    }

    public void setValidatedAt(LocalDateTime validatedAt) {
        this.validatedAt = validatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString method
    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", tokenType=" + tokenType +
                ", revoked=" + revoked +
                ", expired=" + expired +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", validatedAt=" + validatedAt +
                ", user=" + user +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token1 = (Token) o;

        if (revoked != token1.revoked) return false;
        if (expired != token1.expired) return false;
        if (!id.equals(token1.id)) return false;
        if (!token.equals(token1.token)) return false;
        if (tokenType != token1.tokenType) return false;
        if (!createdAt.equals(token1.createdAt)) return false;
        if (!expiresAt.equals(token1.expiresAt)) return false;
        if (!validatedAt.equals(token1.validatedAt)) return false;
        return user.equals(token1.user);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + token.hashCode();
        result = 31 * result + tokenType.hashCode();
        result = 31 * result + (revoked ? 1 : 0);
        result = 31 * result + (expired ? 1 : 0);
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + expiresAt.hashCode();
        result = 31 * result + validatedAt.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String token;
        private TokenType tokenType = TokenType.BEARER;
        private boolean revoked;
        private boolean expired;
        private LocalDateTime createdAt;
        private LocalDateTime expiresAt;
        private LocalDateTime validatedAt;
        private User user;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder tokenType(TokenType tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public Builder revoked(boolean revoked) {
            this.revoked = revoked;
            return this;
        }

        public Builder expired(boolean expired) {
            this.expired = expired;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder expiresAt(LocalDateTime expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder validatedAt(LocalDateTime validatedAt) {
            this.validatedAt = validatedAt;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Token build() {
            return new Token(id, token, tokenType, revoked, expired, createdAt, expiresAt, validatedAt, user);
        }
    }
}