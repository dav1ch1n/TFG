package BonkData.service;

import BonkData.model.Personajes;
import BonkData.repositorio.PersonajesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajesSerivice {
    @Autowired
    private PersonajesRepository perRepositorio;
    public Personajes getOne(Long id) {
        return perRepositorio.findById(id).orElse(null);
    }
    public List<Personajes> getAll() {
        return perRepositorio.findAll();
    }

    public Personajes update(Long id, Personajes obj) {
        return perRepositorio.save(obj);
    }

    public void delete(Long id) {
        perRepositorio.deleteById(id);
    }

    public Personajes insert(Personajes obj) {
        return perRepositorio.save(obj);
    }
}
