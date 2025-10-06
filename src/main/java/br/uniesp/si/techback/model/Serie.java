package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
@Data @NoArgsConstructor @AllArgsConstructor
public class Serie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    private Integer temporadas;           // opcional: total de temporadas
    private String classificacaoEtaria;   // ex.: "12", "16", "18"

    // Opcional: reutilizar sua entidade Genero
    @ManyToMany
    @JoinTable(name = "serie_genero",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private List<Genero> generos = new ArrayList<>();

    // Série possui muitos episódios
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("temporada ASC, numero ASC") // sempre ordenados
    private List<Episodio> episodios = new ArrayList<>();
}
