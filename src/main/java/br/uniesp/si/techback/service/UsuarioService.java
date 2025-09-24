package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    // 📦 O construtor recebe o "caderninho mágico"
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // ✍️ Salvar usuário (cadastra no banco)
    public Usuario salvar(Usuario usuario) {
        // 🕒 Define data de criação e atualização antes de salvar
        if (usuario.getCriadoEm() == null) {
            usuario.setCriadoEm(LocalDateTime.now());
        }
        usuario.setAtualizadoEm(LocalDateTime.now());

        return repository.save(usuario);
    }

    // 📖 Listar todos os usuários
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // 🔎 Buscar usuário por ID
    public Usuario buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    // ❌ Deletar usuário por ID
    public void deletar(UUID id) {
        repository.deleteById(id);
    }

}
