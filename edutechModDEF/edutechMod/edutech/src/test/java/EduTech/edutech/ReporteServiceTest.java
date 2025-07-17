package EduTech.edutech;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import EduTech.edutech.model.Reporte;
import EduTech.edutech.repository.ReporteRepository;
import EduTech.edutech.service.ReporteService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")

@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.sql.init.mode=never"
})

public class ReporteServiceTest {
    @Autowired
    private ReporteService reporteService;

    @MockBean
    private ReporteRepository reporteRepository;

    @BeforeEach
    public void setup() {
        System.out.println("\n=== Preparando entorno de prueba ===");
    }

    @Test
    public void testFindAll() {
        System.out.println("\n--- Ejecutando prueba testFindAll() ---");

        // Configuración del mock
        Timestamp fecha = Timestamp.valueOf("2025-06-03 02:07:48.534000000");
        Reporte reporteEjemplo = new Reporte(1, fecha, "Error en formulario");

        when(reporteRepository.findAll()).thenReturn(List.of(reporteEjemplo));
        System.out.println("Mock configurado: findAll() devolverá una lista con 1 reporte");

        // Ejecución
        List<Reporte> reportes = reporteService.findAll();
        System.out.println("Se invocó reporteService.findAll()");
        System.out.println("Resultado obtenido: " + reportes);

        // Verificaciones
        assertNotNull(reportes, "La lista de reportes no debería ser nula");
        assertEquals(1, reportes.size(), "Debería haber exactamente 1 reporte en la lista");
        System.out.println("✓ Verificación exitosa: La lista contiene 1 reporte");

        System.out.println("--- Prueba testFindAll() completada con éxito ---");
    }

    @Test
    public void testFindById() {
        System.out.println("\n--- Ejecutando prueba testFindById() ---");

        Integer id = 1;
        long numeroLong = id;
        Timestamp fecha = Timestamp.valueOf("2025-06-03 02:07:48.534000000");
        Reporte reporte = new Reporte(id, fecha, "Pantalla congelada");

        when(reporteRepository.findById(numeroLong)).thenReturn(Optional.of(reporte));
        System.out.println("Mock configurado: findById(" + id + ") devolverá un reporte");

        // Ejecución
        Reporte found = reporteService.findById(id);
        System.out.println("Se invocó reporteService.findById(" + id + ")");
        System.out.println("Reporte encontrado: " + found);

        // Verificación
        assertNotNull(found, "El reporte encontrado no debería ser nulo");
        assertEquals(id, found.getId(), "El ID del reporte debería coincidir");
        System.out.println("✓ Verificación exitosa: El reporte tiene el ID esperado");

        System.out.println("--- Prueba testFindById() completada con éxito ---");
    }

    @Test
    public void testSave() {
        System.out.println("\n--- Ejecutando prueba testSave() ---");

        Timestamp fecha = Timestamp.valueOf("2025-06-03 02:07:48.534000000");
        Reporte reporte = new Reporte(null, fecha, "Carga lenta de página");

        when(reporteRepository.save(reporte)).thenReturn(reporte);
        System.out.println("Mock configurado: save() devolverá el reporte guardado");

        // Ejecución
        Reporte saved = reporteService.save(reporte);
        System.out.println("Se invocó reporteService.save()");
        System.out.println("Reporte guardado: " + saved);

        // Verificación
        assertNotNull(saved, "El reporte guardado no debería ser nulo");
        assertEquals("Carga lenta de página", saved.getTipoIncidencia(), "El tipo de incidencia debería coincidir");
        System.out.println("✓ Verificación exitosa: El reporte se guardó correctamente");

        System.out.println("--- Prueba testSave() completada con éxito ---");
    }

    @Test
    public void testDeleteById() {
        System.out.println("\n--- Ejecutando prueba testDeleteById() ---");

        Integer id = 1;
        long numeroLong = id;
        doNothing().when(reporteRepository).deleteById(numeroLong);
        System.out.println("Mock configurado: deleteById(" + id + ") no hará nada");

        // Ejecución
        reporteService.delete(numeroLong);
        System.out.println("Se invocó reporteService.delete(" + id + ")");

        // Verificación
        verify(reporteRepository, times(1)).deleteById(numeroLong);
        System.out.println("✓ Verificación exitosa: Se eliminó el reporte con ID " + id);

        System.out.println("--- Prueba testDeleteById() completada con éxito ---");
    }
}