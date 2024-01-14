package Aplicativo.AppCarona.Service;


import Aplicativo.AppCarona.JpaRepository.CarroRepository;
import Aplicativo.AppCarona.JpaRepository.MotoristaRepository;
import Aplicativo.AppCarona.JpaRepository.UsuarioRepository;
import Aplicativo.AppCarona.Model.Carro;
import Aplicativo.AppCarona.Model.Motorista;
import Aplicativo.AppCarona.Model.Usuario;
import Aplicativo.AppCarona.Service.Interface.MotoristaServiceImp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService implements MotoristaServiceImp {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Motorista tornarMotorista(Motorista motorista) {
        // Certifique-se de que os IDs de Carro e Usuário existem
        Carro carroExistente = carroRepository.findById(motorista.getCarro().getId())
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));

        Usuario usuarioExistente = usuarioRepository.findById(motorista.getUsuario().getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        // Associe o Carro e o Usuário ao Motorista
        motorista.setCarro(carroExistente);
        motorista.setUsuario(usuarioExistente);
        motorista.setEhMotorista(true);

        // Salvando o Motorista

        return motoristaRepository.save(motorista);
    }
}
