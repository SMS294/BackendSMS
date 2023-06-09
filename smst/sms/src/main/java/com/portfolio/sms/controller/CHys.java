package com.portfolio.sms.controller;

import com.portfolio.sms.Dto.dtoHys;
import com.portfolio.sms.entity.HyS;
import com.portfolio.sms.security.controller.Mensaje;
import com.portfolio.sms.service.Shys;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @CrossOrigin(origins = {"https://front-portfolio1.web.app","http://localhost:4200"})
    @RequestMapping("/skill")
    public class CHys {

        @Autowired
        Shys shys;

        @GetMapping("/lista")
        public ResponseEntity<List<HyS>> list() {
            List<HyS> list = shys.list();
            return new ResponseEntity(list, HttpStatus.OK);
        }

        @GetMapping("/detail/{id}")
        public ResponseEntity<HyS> getById(@PathVariable("id") int id) {
            if (!shys.existsById(id)) {
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            }
            HyS hys = shys.getOne(id).get();
            return new ResponseEntity(hys, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if (!shys.existsById(id)) {
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            }
            shys.delete(id);
            return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
        }

        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody dtoHys dtohys) {
            if (StringUtils.isBlank(dtohys.getNombre())) {
                return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (shys.existsByNombre(dtohys.getNombre())) {
                return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
            }

            HyS hys = new HyS(dtohys.getNombre(), dtohys.getPorcentaje());
            shys.save(hys);

            return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys) {
            //Validamos si existe el ID
            if (!shys.existsById(id)) {
                return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
            }
            //Compara nombre de skills
            if (shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get()
                    .getId() != id) {
                return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
            }
            //No puede estar vacio
            if (StringUtils.isBlank(dtohys.getNombre())) {
                return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            }

            HyS hys = shys.getOne(id).get();
            hys.setNombre(dtohys.getNombre());
            hys.setPorcentaje(dtohys.getPorcentaje());

            shys.save(hys);
            return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

        }
        }

