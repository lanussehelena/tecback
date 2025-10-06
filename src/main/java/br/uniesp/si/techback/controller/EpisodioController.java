package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Episodio;
import br.uniesp.si.techback.model.Serie;
import br.uniesp.si.techback.service.EpisodioService;
import br.uniesp.si.techback.service.SerieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series/{serieId}/episodios")
public class EpisodioController {

    private final EpisodioService episodioService;
    private final SerieService serieService;

    public EpisodioController(EpisodioService episodioService, SerieService serieService) {
        this.episodioService = episodioService;
        this.serieService = serieService;
    }

    @PostMapping
    public Episodio adicionar(@PathVariable Long serieId, @RequestBody Episodio ep) {
        Serie serie = serieService.buscarPorId(serieId);
        ep.setSerie(serie);
        return episodioService.salvar(ep);
    }

    @GetMapping
    public List<Episodio> listar(@PathVariable Long serieId) {
        Serie serie = serieService.buscarPorId(serieId);
        return episodioService.listarPorSerie(serie);
    }

    @DeleteMapping("/{episodioId}")
    public void deletar(@PathVariable Long serieId, @PathVariable Long episodioId) {
        // opcional: validar se o episódio pertence à série antes de deletar
        episodioService.deletar(episodioId);
    }
}
