package Aplicativo.AppCarona.DTO.Resquest;

import Aplicativo.AppCarona.Model.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

public record UsuarioRequest(Usuario motorista, List<Usuario> passageiro) {




}
