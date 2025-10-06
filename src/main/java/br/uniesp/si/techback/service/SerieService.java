package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Serie;
import br.uniesp.si.techback.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository repo;

    public SerieService(SerieRepository repo) { this.repo = repo; }

    public Serie salvar(Serie serie) { return repo.save(serie); }
    public List<Serie> listar() { return repo.findAll(); }

    public Serie buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Série não encontrada"));
    }

    public void deletar(Long id) { repo.deleteById(id); }
}
