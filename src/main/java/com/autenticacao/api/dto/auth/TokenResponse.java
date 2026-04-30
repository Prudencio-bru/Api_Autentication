package com.autenticacao.api.dto.auth;

public record TokenResponse(String accessToken, String tokenType, Long expiresIn,Integer userId) {
    public static TokenResponse bearer(String token, Long exp,Integer userId) {
        return new TokenResponse(token, "Bearer", exp,userId);
    }
}
