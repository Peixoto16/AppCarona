package Aplicativo.AppCarona.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_MOTORISTA")
public class Motorista implements Serializable{

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @OneToOne
    @JoinColumn(name = "usuario_id")  // Adicionado JoinColumn para evitar ambiguidade
    private Usuario usuario;

    @Column(name = "motorista", nullable = false)
    private boolean ehMotorista;



}
