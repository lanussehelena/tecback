package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Favorito;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FavoritoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FavoritoService {

    private final FavoritoRepository repository;

    public FavoritoService(FavoritoRepository repository) {
        this.repository = repository;
    }

    public Favorito adicionarFavorito(Usuario usuario, Filme filme) {
        if (repository.existsByUsuarioAndFilme(usuario, filme)) {
            throw new RuntimeException("Esse filme já está nos favoritos do usuário!");
        }

        Favorito favorito = new Favorito();
        favorito.setUsuario(usuario);
        favorito.setFilme(filme);
        favorito.setCriadoEm(LocalDateTime.now());

        return repository.save(favorito);
    }

    public List<Favorito> listarPorUsuario(Usuario usuario) {
        return repository.findByUsuario(usuario);
    }

    public List<Favorito> listarPorFilme(Filme filme) {
        return repository.findByFilme(filme);
    }

    public void removerFavorito(UUID id) {
        repository.deleteById(id);
    }
}
