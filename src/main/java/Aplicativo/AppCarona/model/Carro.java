package Aplicativo.AppCarona.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;
    @Column(name = "Placa", nullable = false, unique = true)
    private String placa;
    @Column(name = "Cor", nullable = false, unique = true)
    private String cor;
    @Column(name = "Modelo", nullable = false, unique = true)
    private String modelo;

    @JoinColumn(name = "motorista_id")
    @OneToOne
    private Motorista motorista;

}
