package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Enderecos;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.service.EnderecosService;
import br.uniesp.si.techback.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {

    private final EnderecosService enderecosService;
    private final UsuarioService usuariosService;

    public EnderecosController(EnderecosService enderecoService, UsuarioService usuarioService) {
        this.enderecosService = enderecoService;
        this.usuariosService = usuarioService;
    }

    // ➕ Criar endereço para um usuário
    @PostMapping("/{usuarioId}")
    public Enderecos salvar(@PathVariable UUID usuarioId, @RequestBody Enderecos endereco) {
        Usuario usuario = usuariosService.buscarPorId(usuarioId);
        endereco.setUsuario(usuario);
        return enderecosService.salvar(endereco);
    }

    // 📖 Listar endereços de um usuário
    @GetMapping("/{usuarioId}")
    public List<Enderecos> listar(@PathVariable UUID usuarioId) {
        Usuario usuario = usuariosService.buscarPorId(usuarioId);
        return enderecosService.listarPorUsuario(usuario);
    }

    // ❌ Deletar endereço
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        enderecosService.deletar(id);
    }
}
