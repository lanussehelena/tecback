package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Favorito;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.service.FavoritoService;
import br.uniesp.si.techback.service.UsuarioService;
import br.uniesp.si.techback.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;
    private final UsuarioService usuarioService;
    private final FilmeService filmeService;

    public FavoritoController(FavoritoService favoritoService, UsuarioService usuarioService, FilmeService filmeService) {
        this.favoritoService = favoritoService;
        this.usuarioService = usuarioService;
        this.filmeService = filmeService;
    }

    @PostMapping("/{usuarioId}/{filmeId}")
    public Favorito adicionar(@PathVariable UUID usuarioId, @PathVariable Long filmeId) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        Filme filme = filmeService.buscarPorId(filmeId);
        return favoritoService.adicionarFavorito(usuario, filme);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Favorito> listarPorUsuario(@PathVariable UUID usuarioId) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        return favoritoService.listarPorUsuario(usuario);
    }

    @GetMapping("/filme/{filmeId}")
    public List<Favorito> listarPorFilme(@PathVariable Long filmeId) {
        Filme filme = filmeService.buscarPorId(filmeId);
        return favoritoService.listarPorFilme(filme);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable UUID id) {
        favoritoService.removerFavorito(id);
    }
}
