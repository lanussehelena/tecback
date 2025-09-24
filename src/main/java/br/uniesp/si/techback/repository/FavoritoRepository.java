package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Favorito;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FavoritoRepository extends JpaRepository<Favorito, UUID> {
    List<Favorito> findByUsuario(Usuario usuario);
    List<Favorito> findByFilme(Filme filme);
    boolean existsByUsuarioAndFilme(Usuario usuario, Filme filme);
}
