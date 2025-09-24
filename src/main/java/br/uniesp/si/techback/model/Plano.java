package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "planos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 🔑 Identificador único do plano

    @Column(length = 100, nullable = false, unique = true)
    private String nome;
    // 🏷️ Nome do plano (ex: Básico, Premium, VIP)

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
    // 💰 Preço mensal do plano

    @Column(length = 255)
    private String descricao;
    // 📖 Texto explicando os benefícios do plano

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoEm;

    @OneToMany(mappedBy = "plano")
    private List<Usuario> usuarios;
    // 👥 Lista de usuários que estão inscritos nesse plano
}
