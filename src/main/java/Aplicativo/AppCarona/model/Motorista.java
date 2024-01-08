package Aplicativo.AppCarona.model;

import jakarta.persistence.OneToOne;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Motorista {


    private Passageiro passageiro;
    @OneToOne(mappedBy = "motorista")
    private Carro carro;


    // Método para transferir atributos de Passageiro para Motorista
    public void transferirAtributos(Passageiro passageiro) {
        this.passageiro = passageiro;
    }


}
