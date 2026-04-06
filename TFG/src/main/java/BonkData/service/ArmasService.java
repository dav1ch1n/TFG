package BonkData.service;

import BonkData.model.Armas;
import BonkData.repositorio.ArmasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmasSerivice {
    @Autowired
    private ArmasRepository armRepositorio;
    public Armas getOne(Long id) {
        return armRepositorio.findById(id).orElse(null);
    }
    public List<Armas> getAll() {
        return armRepositorio.findAll();
    }

    public Armas update(Long id, Armas obj) {
        return armRepositorio.save(obj);
    }

    public void delete(Long id) {
        armRepositorio.deleteById(id);
    }

    public Armas insert(Armas obj) {
        return armRepositorio.save(obj);
    }
}
