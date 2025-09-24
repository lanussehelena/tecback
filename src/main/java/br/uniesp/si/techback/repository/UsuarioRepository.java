package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    // 🪄 O JpaRepository já cria sozinho:
    // - salvar()
    // - findAll()
    // - findById()
    // - deleteById()
    // e muitos outros!
}
