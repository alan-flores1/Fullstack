package EduTech.edutech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EduTech.edutech.model.Evaluacion;
import EduTech.edutech.service.EvaluacionService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/evaluaciones")

public class EvaluacionController {
    
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<List<Evaluacion>> listar() {
        List<Evaluacion> evaluaciones = evaluacionService.findAll();

        if (evaluaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(evaluaciones);
    }

    @PostMapping
    public ResponseEntity<Evaluacion> guardar(@RequestBody Evaluacion clase) {
        Evaluacion productoNuevo = evaluacionService.save(clase);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> buscar(@PathVariable Integer id) {
        try{
            Evaluacion clase = evaluacionService.findById(id);
            return ResponseEntity.ok(clase);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> actualizar(@PathVariable Integer id, @RequestBody Evaluacion eva) {
        try {
            
            Evaluacion c1 = evaluacionService.findById(id);
            c1.setId(id);
            c1.setNombreEva(eva.getNombreEva());
            c1.setCursoPrueba(eva.getCursoPrueba());
            c1.setPorcentaje(eva.getPorcentaje());
                
            evaluacionService.save(c1);
            return ResponseEntity.ok(c1);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            evaluacionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}

