package com.portfolio.sms.security.repository;

import com.portfolio.sms.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario (String nombreUsuario);
    Optional<Usuario> findByNombreUsuarioOrEmail (String nombreUsuario, String email);
    Optional<Usuario> findByTokenPassword(String tokenPassword);
    boolean existByNombreUsuario (String nombreUsuario);
    boolean existByEmail (String email);

}
