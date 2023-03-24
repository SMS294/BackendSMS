package com.portfolio.sms.Controller;

import com.portfolio.sms.Entity.Persona;
import com.portfolio.sms.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    IPersonaService ipersonaService;
    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
       return ipersonaService.getPersona();}

    @PostMapping("personas/crear")
       public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "la persona fue creada correctamente";
       }

    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }

    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam ("nombre") String nuevoNombre,
                               @RequestParam ("apellido") String nuevoApellido,
                               @RequestParam ("img") String nuevoImg) {
        Persona persona= ipersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

        ipersonaService.savePersona(persona);
        return persona;
        }

}
