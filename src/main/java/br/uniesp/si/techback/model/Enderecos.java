package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "enderecos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    // 🔑 Identificador único do endereço

    @Column(length = 150, nullable = false)
    private String logradouro;
    // 🏠 Nome da rua, avenida, etc

    @Column(length = 50, nullable = false)
    private String bairro;
    // 🏘️ Bairro

    @Column(length = 50, nullable = false)
    private String cidade;
    // 🏙️ Cidade

    @Column(length = 2, nullable = false)
    private String estado;
    // 🗺️ Estado (ex: SP, RJ, PB)

    @Column(length = 8, nullable = false)
    private String cep;
    // 🏷️ Código postal (CEP)

    @Column(length = 10)
    private String numero;
    // 🔢 Número da casa/prédio

    @Column(length = 100)
    private String complemento;
    // 🏢 Ex: apto 101, bloco A

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    // 👤 Dono do endereço
}
