package EduTech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EduTech.edutech.model.CopiaSeguridad;
import EduTech.edutech.service.CopiaService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/copias")

public class CopiaController {

     @Autowired
    private CopiaService copiaService;

    @GetMapping
    public ResponseEntity<List<CopiaSeguridad>> listar() {
        List<CopiaSeguridad> copia = copiaService.findAll();

        if (copia.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(copia);
    }

    @PostMapping
    public ResponseEntity<CopiaSeguridad> guardar(@RequestBody CopiaSeguridad copia) {
        CopiaSeguridad productoNuevo = copiaService.save(copia);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CopiaSeguridad> buscar(@PathVariable Integer id) {
        try{
            CopiaSeguridad copia = copiaService.findById(id);
            return ResponseEntity.ok(copia);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CopiaSeguridad> actualizar(@PathVariable Integer id, @RequestBody CopiaSeguridad copia) {
        try {
            
            CopiaSeguridad c1 = copiaService.findById(id);
            c1.setId(id);
            c1.setNombreCopia(copia.getNombreCopia());
            c1.setFechaCopia(copia.getFechaCopia());
            c1.setPeso(copia.getPeso());
                
            copiaService.save(c1);
            return ResponseEntity.ok(c1);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            copiaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
