package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity // 🏠 Isso diz: "Essa classe é uma casinha no banco de dados"
@Table(name = "usuarios") // 📋 Nome da tabela no banco
@Data // 🪄 Lombok cria automaticamente getters, setters, toString, etc.
@AllArgsConstructor // 🎁 Cria um construtor com todos os campos
@NoArgsConstructor  // 🎁 Cria um construtor vazio

public class Usuario {

    @Id // 🏷️ Diz que esse é o identificador único da tabela (chave primária)
    @GeneratedValue // 🎲 Gera o valor automaticamente
    private UUID id; // 🔑 Aqui é o "RG" do usuário no sistema (não se repete nunca)

    @Column(name = "nome_completo", length = 150, nullable = false)
    private String nomeCompleto;
    // 🧑 Nome completo da pessoa. Até 150 letrinhas. Sempre precisa estar preenchido.

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    // 🎂 Quando a pessoa nasceu. Sempre precisa estar preenchido.

    @Column(length = 254, nullable = false, unique = true)
    private String email;
    // 📧 Email do usuário. Não pode repetir, só um dono por email.

    @Column(name = "senha_hash", length = 60, nullable = false)
    private String senhaHash;
    // 🔒 Senha guardada de forma escondida (não é a senha real, é um código dela).

    @Column(name = "cpf_cnpj", length = 14, unique = true)
    private String cpfCnpj;
    // 🪪 Documento da pessoa ou empresa. Não pode repetir no sistema.

    @Column(length = 20, nullable = false)
    private String perfil;
    // 👑 Perfil do usuário: pode ser ADMIN (manda em tudo) ou USER (só usa o sistema).

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;
    // 🕒 Quando o usuário foi criado no sistema.

    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoEm;
    // 🔄 Quando o usuário foi atualizado pela última vez.

}
