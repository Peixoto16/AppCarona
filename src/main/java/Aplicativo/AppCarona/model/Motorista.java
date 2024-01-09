package Aplicativo.AppCarona.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(name = "TB_MOTORISTA")
@Entity
public class Motorista implements Serializable{

    private static final long serialVersionUID = 1L;


    @Id
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
