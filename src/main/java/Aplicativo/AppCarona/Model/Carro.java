package Aplicativo.AppCarona.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "TB_CARRO")
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "placa", nullable = false, unique = true)
    private String placa;
    @Column(name = "cor", nullable = false, unique = true)
    private String cor;
    @Column(name = "modelo", nullable = false, unique = true)
    private String modelo;


    @OneToOne(mappedBy = "carro")
    private Motorista motorista;

}
