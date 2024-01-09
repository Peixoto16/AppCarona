package Aplicativo.AppCarona.JpaRepository;

import Aplicativo.AppCarona.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
