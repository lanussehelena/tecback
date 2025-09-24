package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Plano;
import br.uniesp.si.techback.service.PlanoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService service;

    public PlanoController(PlanoService service) {
        this.service = service;
    }

    // 📖 Listar planos
    @GetMapping
    public List<Plano> listar() {
        return service.listar();
    }

    // 🔍 Buscar plano por ID
    @GetMapping("/{id}")
    public Plano buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // ➕ Criar novo plano
    @PostMapping
    public Plano salvar(@RequestBody Plano plano) {
        return service.salvar(plano);
    }

    // ❌ Deletar plano
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
