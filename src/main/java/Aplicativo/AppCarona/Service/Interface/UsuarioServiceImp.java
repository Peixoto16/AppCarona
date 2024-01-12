package Aplicativo.AppCarona.Service.Interface;

import Aplicativo.AppCarona.Model.Usuario;

import java.util.Optional;

public interface UsuarioServiceImp {

    Usuario criarUsuario(Usuario usuario);
    Optional<Usuario> obterUsuarioPorId(Long id);
}

