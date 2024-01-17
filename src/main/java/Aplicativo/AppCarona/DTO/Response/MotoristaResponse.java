package Aplicativo.AppCarona.DTO.Response;

import Aplicativo.AppCarona.Model.Carro;
import Aplicativo.AppCarona.Model.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;


public record MotoristaResponse(Long id, Carro carro, Usuario usuario) {
    // Outros campos necessários para a resposta do motorista




}
