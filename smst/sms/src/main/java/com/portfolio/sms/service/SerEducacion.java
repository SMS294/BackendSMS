package com.portfolio.sms.service;

import com.portfolio.sms.entity.Educacion;
import com.portfolio.sms.repository.RepEducacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class SerEducacion {
    @Autowired
    RepEducacion repEducacion;

    public List<Educacion> list(){
        return repEducacion.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return repEducacion.findById(id);
    }

    public Optional<Educacion> getByNombreEdu(String nombreE){
        return repEducacion.findByNombreEdu(nombreE);
    }

    public void save(Educacion educacion){
        repEducacion.save(educacion);
    }

    public void delete(int id){
        repEducacion.deleteById(id);
    }

    public boolean existsById(int id){
        return repEducacion.existsById(id);
    }

    public boolean existsByNombreEdu(String nombreE){
        return repEducacion.existsByNombreEdu(nombreE);
    }
}

