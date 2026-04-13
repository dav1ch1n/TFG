package BonkData.controller;

import BonkData.model.Objetos;
import BonkData.service.ObjetosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Objetos")
@CrossOrigin(origins = "http://localhost:5173") // Puerto por defecto
public class ObjetosController {
    private final ObjetosService objService;
    public ObjetosController(ObjetosService objService) {
        this.objService = objService;
    }
    @GetMapping
    public List<Objetos> getAll(){
        return objService.getAll();
    }
    @GetMapping("/{id}")
    public Objetos getById(@PathVariable Long id) {
        return objService.getOne(id);
    }
    @PostMapping
    public Objetos create(@RequestBody Objetos obj) {
        return objService.insert(obj);
    }
    @PutMapping("/{id}")
    public Objetos update(@PathVariable Long id, @RequestBody Objetos obj) {
        return objService.update(id, obj);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        objService.delete(id);
    }
}
