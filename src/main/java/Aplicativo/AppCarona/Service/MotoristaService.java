package Aplicativo.AppCarona.Service;


import Aplicativo.AppCarona.DTO.Response.MotoristaResponse;
import Aplicativo.AppCarona.DTO.Resquest.MotoristaRequest;
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


    public MotoristaResponse tornarMotorista(MotoristaRequest motoristaRequest) {
        // Certifique-se de que os IDs de Carro e Usuário existem
        Carro carroExistente = carroRepository.findById(motoristaRequest.carro().getId())
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));

        Usuario usuarioExistente = usuarioRepository.findById(motoristaRequest.usuario().getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));


        Motorista motorista = motoristaRepository.save(new Motorista(null, carroExistente, usuarioExistente, true));

        // Utilizar projeção para evitar carregar entidade completa do banco de dados
        return new MotoristaResponse(motorista.getId(), motorista.getCarro(), motorista.getUsuario());
    }
}
