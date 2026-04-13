package BonkData.controller;

import BonkData.model.Personajes;
import BonkData.service.PersonajesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Personajes")
@CrossOrigin(origins = "http://localhost:5173") // Puerto por defecto
public class PersonajesController {
    private final PersonajesService perService;
    public PersonajesController(PersonajesService perService) {
        this.perService = perService;
    }
    @GetMapping
    public List<Personajes> getAll(){
        return perService.getAll();
    }
    @GetMapping("/{id}")
    public Personajes getById(@PathVariable Long id) {
        return perService.getOne(id);
    }
    @PostMapping
    public Personajes create(@RequestBody Personajes per) {
        return perService.insert(per);
    }
    @PutMapping("/{id}")
    public Personajes update(@PathVariable Long id, @RequestBody Personajes per) {
        return perService.update(id, per);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        perService.delete(id);
    }
}
