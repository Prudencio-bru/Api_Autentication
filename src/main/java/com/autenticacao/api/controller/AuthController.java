package com.autenticacao.api.controller;

import com.autenticacao.api.api.ApiError;
import com.autenticacao.api.api.ApiResponse;
import com.autenticacao.api.dto.auth.AtualizarRoleLoginDto;
import com.autenticacao.api.dto.auth.CadastrarUsuarioAuthDto;
import com.autenticacao.api.dto.auth.LoginRequest;
import com.autenticacao.api.dto.auth.TokenResponse;
import com.autenticacao.api.projection.auth.IdAuthProjection;
import com.autenticacao.api.security.JwtProperties;
import com.autenticacao.api.security.JwtService;
import com.autenticacao.api.service.auth.AuthService;
import com.autenticacao.api.util.DateTimeBR;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final JwtProperties props;
    private final AuthService authService;
    //private final AcessoService acessoService;

    public AuthController(
            JwtService jwtService,
            JwtProperties props,
            AuthService authService
            //AcessoService acessoService
    ) {
        this.jwtService = jwtService;
        this.props = props;
        this.authService = authService;
        //this.acessoService = acessoService;
    }

    @PostMapping("/login")
    @SecurityRequirements()
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest body, HttpServletRequest req) {
        try {
            var usuario = authService.login(body.username(), body.password(), req);

            Integer idPessoa = authService.idPessoaAuth(body.username())
                    .stream()
                    .findFirst()
                    .map(IdAuthProjection::getCodigo)
                    .orElse(null);


            UserDetails userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getEmail())
                    .password("")
                    .roles("USER")
                    .build();

            String token = jwtService.generateToken(userDetails);

            return ResponseEntity.ok(
                    TokenResponse.bearer(token, props.expiresIn(), idPessoa)
            );

        } catch (IllegalArgumentException ex) {

            ApiError err = new ApiError("LOGIN-INVALIDO", ex.getMessage(), null);
            ApiResponse<String> r = ApiResponse.error(
                    err,
                    req.getRequestURI(),
                    HttpStatus.UNAUTHORIZED.value()
            );

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(r);

            }

        }

}
