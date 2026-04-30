package com.autenticacao.api.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "O username é obrigatório")
        String username,

        @NotBlank(message = "A password é obrigatória")
        String password

) {
}
