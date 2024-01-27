package Aplicativo.AppCarona.JpaRepository;

import Aplicativo.AppCarona.Model.Carro;
import Aplicativo.AppCarona.Model.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {


}
