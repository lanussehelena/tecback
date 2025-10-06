package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Episodio;
import br.uniesp.si.techback.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
    List<Episodio> findBySerieOrderByTemporadaAscNumeroAsc(Serie serie);
}
