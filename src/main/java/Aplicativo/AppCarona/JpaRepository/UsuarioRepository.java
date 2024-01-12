package Aplicativo.AppCarona.JpaRepository;

import Aplicativo.AppCarona.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
}
