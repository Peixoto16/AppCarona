package Aplicativo.AppCarona.Controller;


import Aplicativo.AppCarona.DTO.Response.MotoristaResponse;
import Aplicativo.AppCarona.DTO.Resquest.MotoristaRequest;
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
    public ResponseEntity<MotoristaResponse> tornarMotorista(@RequestBody MotoristaRequest motoristaRequest) {
        MotoristaResponse motoristaResponse = motoristaService.tornarMotorista(motoristaRequest);
        return ResponseEntity.ok(motoristaResponse);
    }

}
