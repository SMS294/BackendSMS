package com.portfolio.sms.service;

import com.portfolio.sms.entity.Persona;
import com.portfolio.sms.Interface.IPersonaService;
import com.portfolio.sms.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired
    IPersonaRepository ipersonaRepository;
    @Override
    public List<Persona> getPersona() {
        return ipersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);

    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return ipersonaRepository.findById(id).orElse(null);
    }
}

