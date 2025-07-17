package EduTech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EduTech.edutech.model.Curso;
import EduTech.edutech.service.CursoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.findAll();

        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso clase) {
        Curso productoNuevo = cursoService.save(clase);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Integer id) {
        try{
            Curso clase = cursoService.findById(id);
            return ResponseEntity.ok(clase);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        try {
            
            Curso c1 = cursoService.findById(id);
            c1.setIdcurso(id);
            c1.setNombre(curso.getNombre());
            c1.setProfesor(curso.getProfesor());
            c1.setCorreo(curso.getCorreo());
                
            cursoService.save(c1);
            return ResponseEntity.ok(c1);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            cursoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
