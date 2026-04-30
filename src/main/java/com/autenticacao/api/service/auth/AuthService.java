package com.autenticacao.api.service.auth;

import com.autenticacao.api.dto.auth.AtualizarRoleLoginDto;
import com.autenticacao.api.projection.auth.AuthProjection;
import com.autenticacao.api.projection.auth.IdAuthProjection;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface AuthService {
    int cadastrarLogin(int id_user, String email, String password, String data_criacao);
    AuthProjection login(String email, String password, HttpServletRequest req);
    int atualizacaoMapeamento(String ip, String dataEntrada, int codPessoa);
    Integer buscarIdPorEmail(String email);
    List<IdAuthProjection> idPessoaAuth(String email);
    int atualizarRoleLogin(AtualizarRoleLoginDto atualizarRoleLogin);

}
