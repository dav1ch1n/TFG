package BonkData.controller;

import BonkData.model.Tomos;
import BonkData.service.TomosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BonkData/model/Tomos")
@CrossOrigin(origins = "http://localhost:3000")
public class TomosController {
    private final TomosService tomService;
    public TomosController(TomosService tomService) {
        this.tomService = tomService;
    }
    @GetMapping
    public List<Tomos> getAll(){
        return tomService.getAll();
    }
    @GetMapping("/{id}")
    public Tomos getById(@PathVariable Long id) {
        return tomService.getOne(id);
    }
    @PostMapping
    public Tomos create(@RequestBody Tomos tom) {
        return tomService.insert(tom);
    }
    @PutMapping("/{id}")
    public Tomos update(@PathVariable Long id, @RequestBody Tomos tom) {
        return tomService.update(id, tom);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tomService.delete(id);
    }
}
