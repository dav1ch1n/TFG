package BonkData.controller;

import BonkData.model.Estadisticas;
import BonkData.service.EstadisticasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Estadisticas")
@CrossOrigin(origins = "http://localhost:3000")
public class EstadisticasController {
    private final EstadisticasService estService;
    public EstadisticasController(EstadisticasService estService) {
        this.estService = estService;
    }
    @GetMapping
    public List<Estadisticas> getAll(){
        return estService.getAll();
    }
    @GetMapping("/{id}")
    public Estadisticas getById(@PathVariable Long id) {
        return estService.getOne(id);
    }
    @PostMapping
    public Estadisticas create(@RequestBody Estadisticas est) {
        return estService.insert(est);
    }
    @PutMapping("/{id}")
    public Estadisticas update(@PathVariable Long id, @RequestBody Estadisticas est) {
        return estService.update(id, est);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estService.delete(id);
    }
}
