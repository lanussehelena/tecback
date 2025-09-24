package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "favoritos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    // 🔑 Identificador único do favorito

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    // 👤 O usuário que marcou como favorito

    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private Filme filme;
    // 🎬 O filme que foi marcado como favorito

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;
    // 🕒 Quando o usuário favoritou o filme
}
