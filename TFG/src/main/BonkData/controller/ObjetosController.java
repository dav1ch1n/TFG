package BonkData.controller;

import BonkData.model.Objetos;
import BonkData.service.ObjetosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Objetos")
public class ObjetosController {
    private final ObjetosService objService;
    public ObjetosController(ObjetosService objService) {
        objService = objService;
    }
    @GetMapping
    public List<Objetos> getAll(){
        return objService.getAll();
    }
    @GetMapping("/{id}")
    public Objetos getById(@PathVariable String id) {
        return objService.getOne(id);
    }
    @PostMapping
    public Objetos create(@RequestBody Objetos emp) {
        return objService.insert(emp);
    }
    @PutMapping("/{id}")
    public Objetos update(@PathVariable String id, @RequestBody Objetos emp) {
        return objService.update(id, emp);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        objService.delete(id);
    }
}
