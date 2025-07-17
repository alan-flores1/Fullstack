package EduTech.edutech;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import EduTech.edutech.model.Curso;
import EduTech.edutech.repository.CursoRepository;
import EduTech.edutech.service.CursoService;

@SpringBootTest
@ActiveProfiles("test")


@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.sql.init.mode=never"
})

public class CursoServiceTest {
    
    @Autowired
    private CursoService cursoService;
    
    @MockBean
    private CursoRepository cursoRepository;

    @BeforeEach
    public void setup() {
        System.out.println("\n=== Preparando entorno de prueba CursoService ===");
    }

    @Test
    public void testFindAll() {
        System.out.println("\n--- Ejecutando prueba testFindAll() ---");

        Curso curso = new Curso(1, "Programación Java", "Juan Pérez", "juan@correo.cl");
        when(cursoRepository.findAll()).thenReturn(List.of(curso));

        System.out.println("Mock configurado: findAll() devolverá una lista con 1 curso");

        List<Curso> cursos = cursoService.findAll();
        System.out.println("Se invocó cursoService.findAll()");
        System.out.println("Resultado obtenido: " + cursos);

        assertNotNull(cursos, "La lista no debería ser nula");
        assertEquals(1, cursos.size(), "Debe haber exactamente 1 curso");
        System.out.println("✓ Verificación exitosa:La lista contiene 1 curso");

        System.out.println("--- Prueba testFindAll() completada ---");
    }

    @Test
    public void testFindById() {
        System.out.println("\n--- Ejecutando prueba testFindById() ---");
        int codigo= 1;
        long id = codigo;
        Curso curso = new Curso(codigo, "Estructura de Datos", "Carla Gómez", "carla@duoc.cl");
        when(cursoRepository.findById(id)).thenReturn(Optional.of(curso));

        System.out.println("Mock configurado: findById() devolverá un curso con ID " + id);

        Curso encontrado = cursoService.findById(id);
        System.out.println("Se invocó cursoService.findById(" + id + ")");
        System.out.println("Objeto encontrado: " + encontrado);

        assertNotNull(encontrado, "El curso no debería ser nulo");
        assertEquals(codigo, encontrado.getIdcurso(), "El ID debería coincidir");

        System.out.println("✓ Verificación exitosa: El ID coincide correctamente");

        System.out.println("--- Prueba testFindById() completada ---");
    }

    @Test
    public void testSave() {
        System.out.println("\n--- Ejecutando prueba testSave() ---");

        Curso curso = new Curso(null, "Redes de Computadores", "Pedro Torres", "pedro@edu.cl");

        when(cursoRepository.save(curso)).thenReturn(new Curso(2, "Redes de Computadores", "Pedro Torres", "pedro@edu.cl"));
        System.out.println("Mock configurado: save() devolverá el curso proporcionado");

        Curso guardado = cursoService.save(curso);
        System.out.println("Se invocó cursoService.save()");
        System.out.println("Objeto guardado: " + guardado);

        assertNotNull(guardado, "El objeto guardado no debería ser nulo");
        assertEquals("Redes de Computadores", guardado.getNombre(), "El nombre debería coincidir");
        System.out.println("✓ Verificación exitosa: El objeto fue guardado correctamente");

        System.out.println("--- Prueba testSave() completada con éxito ---");
}
    @Test
    public void testDelete() {
        System.out.println("\n--- Ejecutando prueba testDelete() ---");
        int codigo=1;
        long id = codigo;
        doNothing().when(cursoRepository).deleteById(id);
        System.out.println("Mock configurado: deleteById() no hará nada con ID " + id);

        cursoService.delete(id);
        verify(cursoRepository, times(1)).deleteById(id);
        System.out.println("✓ Verificación exitosa: Se invocó deleteById una vez");

        System.out.println("--- Prueba testDelete() completada ---");
    }
}
