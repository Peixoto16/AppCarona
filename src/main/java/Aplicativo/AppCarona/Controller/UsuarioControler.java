package Aplicativo.AppCarona.Controller;

import Aplicativo.AppCarona.Model.Usuario;
import Aplicativo.AppCarona.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControler {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.obterUsuarioPorId(id);

        return usuarioOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario novoUsuario) {
        Usuario usuarioCriado = usuarioService.criarUsuario(novoUsuario);
        return ResponseEntity.ok(usuarioCriado);
    }



}