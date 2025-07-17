package EduTech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EduTech.edutech.model.CopiaSeguridad;
import EduTech.edutech.service.CopiaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/copias")
@Tag(name="Copias de seguridad", description = "Operaciones relacionadas con las copias")
public class CopiaController {

    @Autowired
    private CopiaService copiaService;

    @GetMapping
    @Operation(summary = "Obtener todas las copias", description = "Obtiene una lista de todas las copias")
    public ResponseEntity<List<CopiaSeguridad>> listar() {
        List<CopiaSeguridad> copia = copiaService.findAll();

        if (copia.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(copia);
    }

    @PostMapping
    @Operation(summary = "Agregar una nueva Copia", description = "Agrega una nueva copia a la lista")
    public ResponseEntity<CopiaSeguridad> guardar(@RequestBody CopiaSeguridad copia) {
        CopiaSeguridad productoNuevo = copiaService.save(copia);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener copia por id", description = "Obtiene una copia con el id especificado")
    public ResponseEntity<CopiaSeguridad> buscar(@PathVariable long id) {
        try{
            CopiaSeguridad copia = copiaService.findById(id);
            return ResponseEntity.ok(copia);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar copia por id", description = "Modifica la copia con el id especificado")
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
    @Operation(summary = "Borrar copia por id", description = "Borra la copia que coincida con el id ingresado")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            copiaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
