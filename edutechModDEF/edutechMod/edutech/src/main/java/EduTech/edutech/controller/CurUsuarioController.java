package EduTech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EduTech.edutech.model.CursoUsuario;
import EduTech.edutech.service.CurUsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cursos_usuarios")
public class CurUsuarioController {

    
    @Autowired
    private CurUsuarioService cursoUsuarioService;

    @GetMapping
    public ResponseEntity<List<CursoUsuario>> listar() {
        List<CursoUsuario> cursosUsuarios = cursoUsuarioService.findAll();

        if (cursosUsuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursosUsuarios);
    }

    @PostMapping
    public ResponseEntity<CursoUsuario> guardar(@RequestBody CursoUsuario curUsuario) {
        CursoUsuario productoNuevo = cursoUsuarioService.save(curUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoUsuario> buscar(@PathVariable Integer id) {
        try{
            CursoUsuario clase = cursoUsuarioService.findById(id);
            return ResponseEntity.ok(clase);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoUsuario> actualizar(@PathVariable Integer id, @RequestBody CursoUsuario cursoUsuar) {
        try {
            
            CursoUsuario c1 = cursoUsuarioService.findById(id);
            c1.setIdCursoUsuario(id);;
      
            cursoUsuarioService.save(c1);
            return ResponseEntity.ok(c1);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            cursoUsuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
