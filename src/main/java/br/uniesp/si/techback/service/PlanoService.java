package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Plano;
import br.uniesp.si.techback.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlanoService {

    private final PlanoRepository repository;

    public PlanoService(PlanoRepository repository) {
        this.repository = repository;
    }

    public Plano salvar(Plano plano) {
        if (plano.getCriadoEm() == null) {
            plano.setCriadoEm(LocalDateTime.now());
        }
        plano.setAtualizadoEm(LocalDateTime.now());
        return repository.save(plano);
    }

    public List<Plano> listar() {
        return repository.findAll();
    }

    public Plano buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado!"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
