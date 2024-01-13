package Aplicativo.AppCarona.Service.Interface;

import Aplicativo.AppCarona.Model.Carro;
import Aplicativo.AppCarona.Model.Usuario;

import java.util.Optional;

public interface CarroServiceImp {

    Carro criarCarro(Carro carro);
    Optional<Carro> obterCarroPorId(Long id);
}
