package BonkData.controller;

import BonkData.model.Armas;
import BonkData.service.ArmasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Armas")
public class ArmasController {
    private final ArmasService armService;
    public ArmasController(ArmasService armService) {
        armService = armService;
    }
    @GetMapping
    public List<Armas> getAll(){
        return armService.getAll();
    }
    @GetMapping("/{id}")
    public Armas getById(@PathVariable String id) {
        return armService.getOne(id);
    }
    @PostMapping
    public Armas create(@RequestBody Armas emp) {
        return armService.insert(emp);
    }
    @PutMapping("/{id}")
    public Armas update(@PathVariable String id, @RequestBody Armas emp) {
        return armService.update(id, emp);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        armService.delete(id);
    }
}
