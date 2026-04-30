package com.autenticacao.api.projection.auth;

public interface AuthProjection {
    Integer getIdUser();
    String getEmail();
    String getPassword();   // corresponde a SENHA
}
