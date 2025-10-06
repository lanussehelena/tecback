package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "episodios",
        uniqueConstraints = @UniqueConstraint(
                name = "UK_episodio_numero_por_serie",
                columnNames = {"serie_id","temporada","numero"}))
@Data @NoArgsConstructor @AllArgsConstructor
public class Episodio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false)
    private Integer temporada;  // T1, T2…

    @Column(nullable = false)
    private Integer numero;     // Ep1, Ep2…

    private Integer duracao;    // minutos (opcional)
    @Column(length = 500)
    private String sinopse;

    @ManyToOne(optional = false)
    @JoinColumn(name = "serie_id")
    private Serie serie;
}
