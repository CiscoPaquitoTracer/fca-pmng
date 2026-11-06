package mx.edu.utez.miservicio.service;

import mx.edu.utez.miservicio.model.Persona;
import mx.edu.utez.miservicio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAll(){
        return personaRepository.findAll();
    }

    public Persona create(String nombre){
        Persona p = new Persona();
        p.setNombre(nombre);
        return personaRepository.save(p);
    }
}
