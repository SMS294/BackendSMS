package com.portfolio.sms.controller;

import com.portfolio.sms.Interface.IPersonaService;
import com.portfolio.sms.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin (origins = "*")
public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();}

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "la persona fue creada correctamente";
    }
    @PreAuthorize( "hasRole('ADMIN' )")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }
    @PreAuthorize( "hasRole('ADMIN' )")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam ("nombre") String nuevoNombre,
                               @RequestParam ("apellido") String nuevoApellido,
                               @RequestParam ("img") String nuevoImg) {
        Persona persona= iPersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

        iPersonaService.savePersona(persona);
        return persona;

    }
}

