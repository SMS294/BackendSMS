package com.portfolio.sms.Interface;

import com.portfolio.sms.entity.Persona;

import java.util.List;

public interface IPersonaService {


    //Traer una  lista de personas
    List<Persona> getPersona() ;


    //Guardar un objeto de tipo persona
     public void savePersona (Persona persona);

    //Eliminar un objeto pero lo llamamos por Id
    public void deletePersona(Long id);

    //Buscar una persona por id
    public Persona findPersona(Long id) ;



}


