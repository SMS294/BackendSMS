package com.portfolio.sms.Security.Repository;

import com.portfolio.sms.Security.Entity.Rol;
import com.portfolio.sms.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer > {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

