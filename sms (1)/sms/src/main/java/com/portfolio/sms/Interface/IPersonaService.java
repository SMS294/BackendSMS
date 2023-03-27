package com.portfolio.sms.Interface;

import com.portfolio.sms.Entity.Persona;

import java.util.List;

public interface IPersonaService {
    //Traer una  lista de personas
    List<Persona> getPersona();

    //Guardar un objeto de tipo persona
    void savePersona (Persona persona);

    //Eliminar un objeto pero lo llamamos por Id
    void deletePersona(Long id);

    //Buscar una persona por id
    Persona findPersona(Long id) ;



}


