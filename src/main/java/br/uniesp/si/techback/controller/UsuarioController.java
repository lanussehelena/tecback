package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // GET - listar todos
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable UUID id) {
        return service.buscarPorId(id);
    }

    // POST - salvar novo usuário
    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    // DELETE - remover usuário
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        service.deletar(id);
    }
}
