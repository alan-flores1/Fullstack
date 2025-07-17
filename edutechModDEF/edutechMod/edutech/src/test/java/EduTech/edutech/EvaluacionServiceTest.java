package EduTech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import EduTech.edutech.model.Evaluacion;
import EduTech.edutech.repository.EvaluacionRepository;
import EduTech.edutech.service.EvaluacionService;

@SpringBootTest
@ActiveProfiles("test")


@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.sql.init.mode=never"
})

public class EvaluacionServiceTest {
    @Autowired
    private EvaluacionService evaluacionService;

    @MockBean
    private EvaluacionRepository evaluacionRepository;

    @BeforeEach
    public void setup() {
        System.out.println("\n=== Preparando entorno de prueba ===");
    }

    @Test
    public void testFindAll() {
        System.out.println("\n--- Ejecutando prueba testFindAll() ---");

        Timestamp fecha = Timestamp.valueOf("2025-06-15 10:30:00");
        Evaluacion evaluacion = new Evaluacion(1, "Prueba Unidad 1", "Programación", 25, fecha);

        when(evaluacionRepository.findAll()).thenReturn(List.of(evaluacion));
        System.out.println("Mock configurado: findAll() devolverá una lista con 1 evaluación");

        List<Evaluacion> lista = evaluacionService.findAll();
        System.out.println("Se invocó evaluacionService.findAll()");
        System.out.println("Resultado obtenido: " + lista);

        assertNotNull(lista, "La lista de evaluaciones no debería ser nula");
        assertEquals(1, lista.size(), "Debería haber exactamente 1 evaluación en la lista");
        System.out.println("✓ Verificación exitosa: La lista contiene 1 evaluación");

        System.out.println("--- Prueba testFindAll() completada con éxito ---");
    }

    @Test
    public void testFindById() {
        System.out.println("\n--- Ejecutando prueba testFindById() ---");

        Integer id = 1;
        long numeroLong = id;
        Timestamp fecha = Timestamp.valueOf("2025-06-15 10:30:00");
        Evaluacion evaluacion = new Evaluacion(id, "Evaluación Final", "Bases de Datos", 30, fecha);

        when(evaluacionRepository.findById(numeroLong)).thenReturn(Optional.of(evaluacion));
        System.out.println("Mock configurado: findById(" + id + ") devolverá una evaluación");

        Evaluacion encontrada = evaluacionService.findById(id);
        System.out.println("Se invocó evaluacionService.findById(" + id + ")");
        System.out.println("Evaluación encontrada: " + encontrada);

        assertNotNull(encontrada, "La evaluación no debería ser nula");
        assertEquals(id, encontrada.getId(), "El ID de la evaluación debería coincidir");
        System.out.println("✓ Verificación exitosa: La evaluación tiene el ID esperado");

        System.out.println("--- Prueba testFindById() completada con éxito ---");
    }

    @Test
    public void testSave() {
        System.out.println("\n--- Ejecutando prueba testSave() ---");

        Timestamp fecha = Timestamp.valueOf("2025-06-20 15:00:00");
        Evaluacion evaluacion = new Evaluacion(null, "Evaluación Diagnóstica", "Algoritmos", 10, fecha);

        when(evaluacionRepository.save(evaluacion)).thenReturn(
            new Evaluacion(2, "Evaluación Diagnóstica", "Algoritmos", 10, fecha)
        );
        System.out.println("Mock configurado: save() devolverá la evaluación guardada");

        Evaluacion guardada = evaluacionService.save(evaluacion);
        System.out.println("Se invocó evaluacionService.save()");
        System.out.println("Evaluación guardada: " + guardada);

        assertNotNull(guardada, "La evaluación guardada no debería ser nula");
        assertEquals("Evaluación Diagnóstica", guardada.getNombreEva(), "El nombre de la evaluación debería coincidir");
        System.out.println("✓ Verificación exitosa: La evaluación se guardó correctamente");

        System.out.println("--- Prueba testSave() completada con éxito ---");
    }

    @Test
    public void testDeleteById() {
        System.out.println("\n--- Ejecutando prueba testDeleteById() ---");

        Integer id = 1;
        long numeroLong = id;
        doNothing().when(evaluacionRepository).deleteById(numeroLong);
        System.out.println("Mock configurado: deleteById(" + id + ") no hará nada");

        evaluacionService.delete(numeroLong);
        System.out.println("Se invocó evaluacionService.delete(" + id + ")");

        verify(evaluacionRepository, times(1)).deleteById(numeroLong);
        System.out.println("✓ Verificación exitosa: Se eliminó la evaluación con ID " + id);

        System.out.println("--- Prueba testDeleteById() completada con éxito ---");
    }
}

