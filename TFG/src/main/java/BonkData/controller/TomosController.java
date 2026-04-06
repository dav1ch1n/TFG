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
        tomService = tomService;
    }
    @GetMapping
    public List<Tomos> getAll(){
        return tomService.getAll();
    }
    @GetMapping("/{id}")
    public Tomos getById(@PathVariable String id) {
        return tomService.getOne(id);
    }
    @PostMapping
    public Tomos create(@RequestBody Tomos emp) {
        return tomService.insert(emp);
    }
    @PutMapping("/{id}")
    public Tomos update(@PathVariable String id, @RequestBody Tomos emp) {
        return tomService.update(id, emp);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        tomService.delete(id);
    }
}
