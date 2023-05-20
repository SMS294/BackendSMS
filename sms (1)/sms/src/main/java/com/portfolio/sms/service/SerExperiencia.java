package com.portfolio.sms.service;

import com.portfolio.sms.entity.Experiencia;
import com.portfolio.sms.repository.RepExperiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class SerExperiencia {
    @Autowired
    RepExperiencia repExperiencia;

    public List<Experiencia> list(){
        return repExperiencia.findAll();
    }

    public Optional<Experiencia> getOne(int id){
        return repExperiencia.findById(id);
    }

    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return repExperiencia.findByNombreExp(nombreExp);
    }

    public void save(Experiencia expe){
        repExperiencia.save(expe);
    }

    public void delete(int id){
        repExperiencia.deleteById(id);
    }

    public boolean existsById(int id){
        return repExperiencia.existsById(id);
    }

    public boolean existsByNombreExp(String nombreExp){
        return repExperiencia.existsByNombreExp(nombreExp);
    }
}

