package BonkData.service;

import BonkData.model.Tomos;
import BonkData.repositorio.TomosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TomosSerivice {
    @Autowired
    private TomosRepository tomRepositorio;
    public Tomos getOne(Long id) {
        return tomRepositorio.findById(id).orElse(null);
    }
    public List<Tomos> getAll() {
        return tomRepositorio.findAll();
    }

    public Tomos update(Long id, Tomos obj) {
        return tomRepositorio.save(obj);
    }

    public void delete(Long id) {
        tomRepositorio.deleteById(id);
    }

    public Tomos insert(Tomos obj) {
        return tomRepositorio.save(obj);
    }
}
