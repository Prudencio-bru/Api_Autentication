package com.autenticacao.api.dto.auth;

public class CadastrarUsuarioAuthDto {
    private int id_user;
    private String email;
    private String password;

    public int getCodigo() {
        return id_user;
    }

    public void setCodigo(int codigo) {
        this.id_user = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return password;
    }

    public void setSenha(String senha) {
        this.password = senha;
    }

}
