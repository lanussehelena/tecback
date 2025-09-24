package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Enderecos;
import br.uniesp.si.techback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecosRepository extends JpaRepository<Enderecos, UUID> {
    List<Enderecos> findByUsuario(Usuario usuario);
}
