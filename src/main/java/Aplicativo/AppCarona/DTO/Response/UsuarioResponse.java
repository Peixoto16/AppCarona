package Aplicativo.AppCarona.DTO.Response;

import Aplicativo.AppCarona.Model.Enum.UsuarioEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UsuarioResponse(Long id,String cpf,String nome, LocalDate dataNascimento, UsuarioEnum usuarioEnum) {



}
