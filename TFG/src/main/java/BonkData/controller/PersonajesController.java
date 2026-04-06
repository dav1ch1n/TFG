package BonkData.controller;

import BonkData.model.Personajes;
import BonkData.service.PersonajesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Personajes")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonajesController {
    private final PersonajesService perService;
    public PersonajesController(PersonajesService perService) {
        perService = perService;
    }
    @GetMapping
    public List<Personajes> getAll(){
        return perService.getAll();
    }
    @GetMapping("/{id}")
    public Personajes getById(@PathVariable String id) {
        return perService.getOne(id);
    }
    @PostMapping
    public Personajes create(@RequestBody Personajes emp) {
        return perService.insert(emp);
    }
    @PutMapping("/{id}")
    public Personajes update(@PathVariable String id, @RequestBody Personajes emp) {
        return perService.update(id, emp);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        perService.delete(id);
    }
}
