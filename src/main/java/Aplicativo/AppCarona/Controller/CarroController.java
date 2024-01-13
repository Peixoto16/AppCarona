package Aplicativo.AppCarona.Controller;

import Aplicativo.AppCarona.Model.Carro;
import Aplicativo.AppCarona.Model.Usuario;
import Aplicativo.AppCarona.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Long id) {
        Optional<Carro> carroOptional = carroService.obterCarroPorId(id);

        return carroOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carro> createCarro(@RequestBody Carro novoCarro) {
        Carro carroCriado = carroService.criarCarro(novoCarro);
        return ResponseEntity.ok(carroCriado);
    }

}
