package Aplicativo.AppCarona.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "cpf", nullable = false, unique = true)
    private String telefone;
    @Column(name = "name", nullable = false)
    private String nome;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToOne(mappedBy = "usuario")  // Corrigido para "passageiro" em vez de "motorista"
    private Motorista motorista;


}
