package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Serie;
import br.uniesp.si.techback.service.SerieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService service;

    public SerieController(SerieService service) { this.service = service; }

    @PostMapping
    public Serie criar(@RequestBody Serie serie) { return service.salvar(serie); }

    @GetMapping
    public List<Serie> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Serie buscar(@PathVariable Long id) { return service.buscarPorId(id); }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletar(id); }
}
