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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "passageiros")
    private List<Usuario> passageiro = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "motorista")
    private Usuario motorista;


    public Corrida(Usuario usuario) {
        this.motorista = motorista;
        this.passageiro = new ArrayList<>();
        System.out.println(motorista.getNome() + " foi adicionado como motorista.");
    }

    public Corrida() {

    }

    public static Corrida criarCorridaComMotorista(Usuario usuario) {
        if (usuario.getUsuarioEnum() == UsuarioEnum.MOTORISTA) {
            return new Corrida(usuario);
        } else {
            System.out.println("Apenas motoristas podem criar corridas.");
            return null;
        }
    }

    public boolean adicionarPassageiro(Usuario passageiro) {
        if (passageiro.getUsuarioEnum() == UsuarioEnum.PASSAGEIRO) {
            this.passageiro.add(passageiro);
            System.out.println(passageiro.getNome() + " foi adicionado como passageiro.");
            return true;
        } else {
            System.out.println("Apenas passageiros podem ser adicionados à corrida.");
            return false;
        }
    }


}
