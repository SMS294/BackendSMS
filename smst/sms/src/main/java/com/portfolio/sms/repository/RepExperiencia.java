package com.portfolio.sms.repository;

import com.portfolio.sms.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepExperiencia extends JpaRepository<Experiencia,Integer> {
    public Optional<Experiencia> findByNombreExp(String nombreExp);
    public boolean existsByNombreExp(String nombreExp);

}
