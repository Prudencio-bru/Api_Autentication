package com.autenticacao.api.implement.auth;

import com.autenticacao.api.dto.auth.AtualizarRoleLoginDto;
import com.autenticacao.api.projection.auth.AuthProjection;
import com.autenticacao.api.projection.auth.IdAuthProjection;
import com.autenticacao.api.repository.auth.AuthRepository;
import com.autenticacao.api.service.auth.AuthService;
import com.autenticacao.api.util.DateTimeBR;
import com.autenticacao.api.util.Ip;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthImplement implements AuthService  {

    private final AuthRepository authRepository;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public AuthImplement(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public int cadastrarLogin(int id_user, String email, String password, String data_criacao) {
        String password_hash = encoder.encode(password);
        if (password_hash.isEmpty()) {
            return 0;
        }
        return authRepository.cadastrarLogin(id_user, email, password_hash, data_criacao);
    }

    @Override
    public AuthProjection login(String email, String password, HttpServletRequest req) {
        System.out.println("[LOGIN] email=" + email);

        List<AuthProjection> list = authRepository.login(email);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("E-mail ou senha não encontrado ou inativo. ------ ------ ---- ("+email +")" );
        }

        AuthProjection user = list.get(0);
        System.out.println("[LOGIN] encontrado codPessoa=" + user.getPassword());

        // Confere hash bcrypt
        boolean ok = encoder.matches(password, user.getPassword());
        System.out.println("[LOGIN] bcrypt matches? " + ok);
        if (!ok) {
            throw new IllegalArgumentException("Senha incorreta.");
        }


        // Registrar mapeamento (não derrube o login se falhar)
        try {
            int mapeamento = atualizacaoMapeamento(
                    Ip.extractClientIp(req),
                    DateTimeBR.nowForDb(),
                    user.getIdUser()
            );
            System.out.println("[LOGIN] mapeamento linhas=" + mapeamento);
        } catch (Exception e) {
            System.out.println("[LOGIN] falha ao registrar mapeamento: " + e.getMessage());
            // não lance exceção aqui por enquanto
        }

        return user;
    }

    @Override
    public int atualizacaoMapeamento(String ip, String data_entrada, int id_user)
    {
        return authRepository.atualizacaoMapeamento(ip,data_entrada,id_user);
    }

    @Override
    public Integer buscarIdPorEmail(String email) {
        return authRepository.buscarIdPorEmail(email);
    }

    @Override
    public List<IdAuthProjection> idPessoaAuth(String email)
    {
        return authRepository.idPessoaAuth(email);
    }


    @Override
    public int atualizarRoleLogin(AtualizarRoleLoginDto dto) {
        return authRepository.atualizaRoleLogin(
                dto.getRole(),
                dto.getId_user()
        );
    }

}
