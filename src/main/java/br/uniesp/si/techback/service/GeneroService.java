package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    private final GeneroRepository repository;

    public GeneroService(GeneroRepository repository) {
        this.repository = repository;
    }

    public List<Genero> listar() {
        return repository.findAll();
    }

    public Genero salvar(Genero genero) {
        return repository.save(genero);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
