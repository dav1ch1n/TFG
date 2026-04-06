package BonkData.service;

import BonkData.model.Objetos;
import BonkData.repositorio.ObjetosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetosSerivice {
    @Autowired
    private ObjetosRepository objRepositorio;
    public Objetos getOne(Long id) {
        return objRepositorio.findById(id).orElse(null);
    }
    public List<Objetos> getAll() {
        return objRepositorio.findAll();
    }

    public Objetos update(Long id, Objetos obj) {
        return objRepositorio.save(obj);
    }

    public void delete(Long id) {
        objRepositorio.deleteById(id);
    }

    public Objetos insert(Objetos obj) {
        return objRepositorio.save(obj);
    }
}
