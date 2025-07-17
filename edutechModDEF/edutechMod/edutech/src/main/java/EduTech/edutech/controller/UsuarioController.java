package EduTech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EduTech.edutech.model.Usuario;
import EduTech.edutech.service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioService.findAll();

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        Usuario productoMuevo = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoMuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Integer id) {
        try{
            Usuario paciente = usuarioService.findById(id);
            return ResponseEntity.ok(paciente);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        try {
            Usuario user = usuarioService.findById(id);
            user.setIdUsuario(id);
            user.setRun(usuario.getRun());
            user.setNombres(usuario.getNombres());
            user.setApellidos(usuario.getApellidos());
            user.setFechaNacimiento(usuario.getFechaNacimiento());
            user.setCorreo(usuario.getCorreo());
            user.setRol(usuario.getRol());

            usuarioService.save(user);
            return ResponseEntity.ok(user);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
