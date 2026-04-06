package BonkData.service;

import BonkData.model.Estadisticas;
import BonkData.repositorio.EstadisticasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasService {
    @Autowired
    private EstadisticasRepository estRepositorio;
    public Estadisticas getOne(Long id) {
        return estRepositorio.findById(id).orElse(null);
    }
    public List<Estadisticas> getAll() {
        return estRepositorio.findAll();
    }

    public Estadisticas update(Long id, Estadisticas obj) {
        return estRepositorio.save(obj);
    }

    public void delete(Long id) {
        estRepositorio.deleteById(id);
    }

    public Estadisticas insert(Estadisticas obj) {
        return estRepositorio.save(obj);
    }
}
