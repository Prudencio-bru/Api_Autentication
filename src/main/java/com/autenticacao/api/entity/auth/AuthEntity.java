package com.autenticacao.api.entity.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class AuthEntity {

    @Id
    private int idLogin;

}
