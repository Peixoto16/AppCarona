package Aplicativo.AppCarona.Controller;

import Aplicativo.AppCarona.Service.CorridaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private CorridaService corridaService;


    @PostMapping("/{id}")
    public ResponseEntity<String> criarCorrida(@PathVariable Long id) {
        try {
            corridaService.verificarEIniciarCorrida(id);
            return new ResponseEntity<>("Corrida criada com sucesso!", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar a corrida", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{corridaId}/{passageiroId}")
    public ResponseEntity<String> addPassageiroACorrida(
            @PathVariable Long corridaId,
            @PathVariable Long passageiroId) {

        try {
            corridaService.addPassageiro(corridaId, passageiroId);
            return ResponseEntity.ok("Passageiro adicionado com sucesso à corrida.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar passageiro à corrida: " + e.getMessage());
        }
    }


}





