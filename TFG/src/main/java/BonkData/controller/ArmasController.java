package BonkData.controller;

import BonkData.model.Armas;
import BonkData.service.ArmasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Armas")
@CrossOrigin(origins = "http://localhost:3000")
public class ArmasController {
    private final ArmasService armService;
    public ArmasController(ArmasService armService) {
        this.armService = armService;
    }
    @GetMapping
    public List<Armas> getAll(){
        return armService.getAll();
    }
    @GetMapping("/{id}")
    public Armas getById(@PathVariable Long id) {
        return armService.getOne(id);
    }
    @PostMapping
    public Armas create(@RequestBody Armas arm) {
        return armService.insert(arm);
    }
    @PutMapping("/{id}")
    public Armas update(@PathVariable Long id, @RequestBody Armas arm) {
        return armService.update(id, arm);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        armService.delete(id);
    }
}
