package Aplicativo.AppCarona.Model;

import Aplicativo.AppCarona.Model.Enum.UsuarioEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TB_CORRIDA")
public class Corrida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToMany
    @JoinTable(
            name = "tb_passageiro_corrida",
            joinColumns = @JoinColumn(name = "corrida_id"),
            inverseJoinColumns = @JoinColumn(name = "passageiro_id")
    )
    private List<Usuario> passageiro = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "motorista_id")
    private Usuario motorista;


}
