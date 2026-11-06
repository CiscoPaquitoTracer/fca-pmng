package mx.edu.utez.miservicio.controller;

import mx.edu.utez.miservicio.model.Persona;
import mx.edu.utez.miservicio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    private PersonaService service;

    @GetMapping()
    public ResponseEntity<List<Persona>> findAll(){
        List<Persona> body = service.getAll();
        return ResponseEntity.ok(body);
    }

    @PostMapping()
    public ResponseEntity<Persona> save(@RequestBody String nombre){
        Persona nueva = service.create(nombre);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }
}
