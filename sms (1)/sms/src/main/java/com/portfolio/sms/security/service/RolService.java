package com.portfolio.sms.security.service;

import com.portfolio.sms.security.entity.Rol;
import com.portfolio.sms.security.enums.RolNombre;
import com.portfolio.sms.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){

        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save (Rol rol){

        rolRepository.save(rol);
    }
    }


