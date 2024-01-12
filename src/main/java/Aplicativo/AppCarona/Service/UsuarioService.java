package Aplicativo.AppCarona.Service;

import Aplicativo.AppCarona.JpaRepository.UsuarioRepository;
import Aplicativo.AppCarona.Model.Usuario;
import Aplicativo.AppCarona.Service.Interface.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UsuarioServiceImp {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario criarUsuario(Usuario usuario) {
        // Adicione lógica de negócios, validações, etc., se necessário
        if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
            throw new IllegalArgumentException("O CPF do usuário é obrigatório.");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }


}
