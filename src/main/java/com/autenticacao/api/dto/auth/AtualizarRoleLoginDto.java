package com.autenticacao.api.dto.auth;

public class AtualizarRoleLoginDto {
    private int role;
    private int id_user;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
