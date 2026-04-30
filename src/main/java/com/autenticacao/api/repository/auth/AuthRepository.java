package com.autenticacao.api.repository.auth;

import com.autenticacao.api.entity.auth.AuthEntity;
import com.autenticacao.api.projection.auth.AuthProjection;
import com.autenticacao.api.projection.auth.IdAuthProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = """
    INSERT INTO login (id_user, email, password, data_criacao) VALUES (:id_user, :email, :password, :data_criacao);
   """,nativeQuery = true)
    int cadastrarLogin(
            @Param("id_user") int  id_user,
            @Param("email") String email,
            @Param("password") String password,
            @Param("data_criacao") String data_criacao
    );


    @Query(value = """
            SELECT
            email,
            password           
            
            FROM login
            WHERE email = :email AND ativo = 1         
    """, nativeQuery = true)
    List<AuthProjection> login(
            @Param("email") String email

    );

    @Transactional
    @Modifying
    @Query(value = """
    UPDATE login
    SET ip = :ip,
    data_entrada = :data_entrada
    WHERE id_user = :id_user
    
    """,nativeQuery = true)
    int atualizacaoMapeamento(
            @Param("ip") String ip,
            @Param("data_entrada") String data_entrada,
            @Param("id_user") int id_user
    );

    @Transactional
    @Modifying
    @Query(value = """
     INSERT INTO login (id_user, email, password, role ,data_criacao)
     VALUES (:id_user,:email,:password, :role, :data_criacao);
    """,nativeQuery = true)
    int cadastrarCredenciais(
            @Param("id_user") Integer id_user,
            @Param("email") String email,
            @Param("password") String password,
            @Param("role") int role,
            @Param("data_criacao") LocalDateTime data_criacao
    );


    @Query(value = """
    SELECT senha, ativo FROM login WHERE id_user = :id_user;
    """,nativeQuery = true)
    List<AuthProjection> varificarUsario(@Param("id_user") int id_user);

    @Query(value = "SELECT id_user FROM login WHERE email = :email", nativeQuery = true)
    Integer buscarIdPorEmail(@Param("email") String email);


    @Query(value = """
            SELECT id_user FROM user WHERE email = :email ;
    """,nativeQuery = true)
    List<IdAuthProjection> idPessoaAuth(@Param("email") String email);

    @Transactional
    @Modifying
    @Query(value = """
        UPDATE login SET
        role = :role
        WHERE id_user = :id_user
        """, nativeQuery = true)
    int atualizaRoleLogin(
            @Param("role") int role,
            @Param("id_user") int id_user
    );

}
