package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Enderecos;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.EnderecosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecosService {

    private final EnderecosRepository repository;

    public EnderecosService(EnderecosRepository repository) {
        this.repository = repository;
    }

    public Enderecos salvar(Enderecos endereco) {
        return repository.save(endereco);
    }

    public List<Enderecos> listarPorUsuario(Usuario usuario) {
        return repository.findByUsuario(usuario);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}
