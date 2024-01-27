package Aplicativo.AppCarona.Service;


import Aplicativo.AppCarona.JpaRepository.CorridaRepository;
import Aplicativo.AppCarona.JpaRepository.UsuarioRepository;
import Aplicativo.AppCarona.Model.Corrida;
import Aplicativo.AppCarona.Model.Enum.UsuarioEnum;
import Aplicativo.AppCarona.Model.Usuario;
import Aplicativo.AppCarona.Service.Interface.CorridaServiceImp;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CorridaService implements CorridaServiceImp {

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public void verificarEIniciarCorrida(Long motoristaId) {
        // Buscar o usuário pelo ID
        Usuario motorista = usuarioRepository.findById(motoristaId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        // Verificar se o usuário é um motorista
        if (motorista.getUsuarioEnum() != UsuarioEnum.MOTORISTA) {
            throw new IllegalArgumentException("O usuário não é um motorista");
        }

        // Criar e iniciar a corrida
        Corrida corrida = new Corrida();
        corrida.setMotorista(motorista);
        // Adicione mais lógica de inicialização da corrida se necessário
        // ...

        // Salvar a corrida no banco de dados (você pode precisar de um repositório para Corrida)
        corridaRepository.save(corrida);
    }

    @Transactional
    public void addPassageiro(Long corridaId, Long passageiroId) {
        Corrida corrida = corridaRepository.findById(corridaId)
                .orElseThrow(() -> new EntityNotFoundException("Corrida não encontrada"));

        Usuario passageiro = usuarioRepository.findById(passageiroId)
                .orElseThrow(() -> new EntityNotFoundException("Passageiro não encontrado"));

        // Verifica se a corrida já atingiu o número máximo de passageiros (3)
        if (corrida.getPassageiro().size() >= 3) {
            throw new IllegalArgumentException("A corrida já atingiu o número máximo de passageiros.");
        }
        // Verifica se o passageiro já está na corrida
        if (corrida.getPassageiro().contains(passageiro)) {
            throw new IllegalArgumentException("Passageiro já está na corrida.");
        }

        corrida.getPassageiro().add(passageiro);
    }



}
