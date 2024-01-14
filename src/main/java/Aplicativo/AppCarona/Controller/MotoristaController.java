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
    public ResponseEntity<String> tornarMotorista(@RequestBody Motorista motorista) {
        motoristaService.tornarMotorista(motorista);
        return ResponseEntity.ok("Motorista criado com sucesso !!");
    }

}
