package com.portfolio.sms.repository;

import com.portfolio.sms.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepEducacion extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion>findByNombreEdu(String nombreE);
    public boolean existsByNombreEdu(String nombreE);
}


