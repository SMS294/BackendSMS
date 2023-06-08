package com.portfolio.sms.repository;

import com.portfolio.sms.entity.HyS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Rhys extends JpaRepository<HyS, Integer> {
    Optional<HyS> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
