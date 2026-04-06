package BonkData.controller;

import BonkData.model.Estadisticas;
import BonkData.service.EstadisticasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Estadisticas")
public class EstadisticasController {
    private final EstadisticasService estService;
    public EstadisticasController(EstadisticasService estService) {
        estService = estService;
    }
    @GetMapping
    public List<Estadisticas> getAll(){
        return estService.getAll();
    }
    @GetMapping("/{id}")
    public Estadisticas getById(@PathVariable String id) {
        return estService.getOne(id);
    }
    @PostMapping
    public Estadisticas create(@RequestBody Estadisticas emp) {
        return estService.insert(emp);
    }
    @PutMapping("/{id}")
    public Estadisticas update(@PathVariable String id, @RequestBody Estadisticas emp) {
        return estService.update(id, emp);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        estService.delete(id);
    }
}
