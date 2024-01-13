package Aplicativo.AppCarona.Service;

import Aplicativo.AppCarona.JpaRepository.CarroRepository;
import Aplicativo.AppCarona.Model.Carro;
import Aplicativo.AppCarona.Service.Interface.CarroServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService implements CarroServiceImp {

    @Autowired
    private CarroRepository carroRepository;
    @Override
    public Carro criarCarro(Carro carro) {
        return carroRepository.save(carro);
    }
    @Override
    public Optional<Carro> obterCarroPorId(Long id) {

        return carroRepository.findById(id);
    }
}
