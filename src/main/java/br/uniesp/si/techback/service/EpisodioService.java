package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Episodio;
import br.uniesp.si.techback.model.Serie;
import br.uniesp.si.techback.repository.EpisodioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodioService {

    private final EpisodioRepository repo;

    public EpisodioService(EpisodioRepository repo) { this.repo = repo; }

    public Episodio salvar(Episodio ep) { return repo.save(ep); }

    public List<Episodio> listarPorSerie(Serie serie) {
        return repo.findBySerieOrderByTemporadaAscNumeroAsc(serie);
    }

    public void deletar(Long id) { repo.deleteById(id); }
}
