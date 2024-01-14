package Aplicativo.AppCarona.Controller;


import Aplicativo.AppCarona.Model.Motorista;
import Aplicativo.AppCarona.Service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<Motorista> tornarMotorista(@RequestBody Motorista motorista) {
       Motorista motor = motoristaService.tornarMotorista(motorista);
        return ResponseEntity.ok(motor);
    }

}
