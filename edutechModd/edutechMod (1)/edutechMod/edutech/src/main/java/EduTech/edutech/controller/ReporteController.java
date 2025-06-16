package EduTech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EduTech.edutech.model.Reporte;
import EduTech.edutech.service.ReporteService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/reportes")
public class ReporteController {

    
    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> listar() {
        List<Reporte> reportes = reporteService.findAll();

        if (reportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportes);
    }

    @PostMapping
    public ResponseEntity<Reporte> guardar(@RequestBody Reporte rep) {
        Reporte productoMuevo = reporteService.save(rep);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoMuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> buscar(@PathVariable Integer id) {
        try{
            Reporte rep = reporteService.findById(id);
            return ResponseEntity.ok(rep);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizar(@PathVariable Integer id, @RequestBody Reporte reporte) {
        try {
            // id, fehcareporte, tipoIncidencia
            Reporte report = reporteService.findById(id);
            report.setId(id);
            report.setFechaReporte(reporte.getFechaReporte());
            report.setTipoIncidencia(reporte.getTipoIncidencia());
        
            reporteService.save(report);
            return ResponseEntity.ok(report);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            reporteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
