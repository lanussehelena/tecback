package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "genero")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relacionamento muitos-para-muitos com Filme
    @ManyToMany(mappedBy = "generos")
    private List<Filme> filmes;
}
