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

import EduTech.edutech.model.Curso;
import EduTech.edutech.model.CursoUsuario;
import EduTech.edutech.model.Usuario;
import EduTech.edutech.repository.CurUsuarioRepository;
import EduTech.edutech.service.CurUsuarioService;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")


@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.sql.init.mode=never"
})

public class CurUsuarioTest {
@Autowired

    private CurUsuarioService curUsuarioService;
    @MockBean
    private CurUsuarioRepository curUsuarioRepository;

    @BeforeEach
    public void setup() {
        System.out.println("\n=== Preparando entorno de prueba ===");
    }

    @Test
    public void testFindAll() {
    System.out.println("\n--- Ejecutando prueba testFindAll() ---");

    // Datos simulados
    Usuario usuario = new Usuario(1, "12345678-9", "Juan", "Pérez", null, "juan@email.com", "ESTUDIANTE");
    Curso curso = new Curso(1, "Matemáticas", "Profe López", "profe@email.com");
    CursoUsuario cursoUsuario = new CursoUsuario(1, usuario, curso, "Buen desempeño", 7.5f, 8.0f, 9.0f, 8.2f);

    when(curUsuarioRepository.findAll()).thenReturn(List.of(cursoUsuario));
    System.out.println("Mock configurado: findAll() devolverá una lista con 1 cursoUsuario");

    List<CursoUsuario> lista = curUsuarioService.findAll();
    System.out.println("Se invocó cursoUsuarioService.findAll()");
    System.out.println("Resultado obtenido: " + lista);

    assertNotNull(lista, "La lista no debería ser nula");
    assertEquals(1, lista.size(), "Debería haber exactamente 1 elemento");
    System.out.println("✓ Verificación exitosa: La lista contiene 1 cursoUsuario");

    System.out.println("--- Prueba testFindAll() completada con éxito ---");
}

@Test
public void testFindById() {
    System.out.println("\n--- Ejecutando prueba testFindById() ---");

    int id = 1;
    long numeroLong = id;
    Usuario usuario = new Usuario(2, "98765432-1", "Ana", "García", null, "ana@email.com", "ESTUDIANTE");
    Curso curso = new Curso(2, "Lenguaje", "Profe Torres", "torres@email.com");
    CursoUsuario cursoUsuario = new CursoUsuario(id, usuario, curso, "Participación activa", 6.5f, 7.0f, 8.0f, 7.2f);

    when(curUsuarioRepository.findById(numeroLong)).thenReturn(Optional.of(cursoUsuario));
    System.out.println("Mock configurado: findById(" + id + ") devolverá un cursoUsuario");

    CursoUsuario encontrado = curUsuarioService.findById(id);
    System.out.println("Se invocó cursoUsuarioService.findById(" + id + ")");
    System.out.println("Objeto encontrado: " + encontrado);

    assertNotNull(encontrado, "El cursoUsuario no debería ser nulo");
    assertEquals(id, encontrado.getIdCursoUsuario(), "El ID debería coincidir");
    System.out.println("✓ Verificación exitosa: El ID coincide correctamente");

    System.out.println("--- Prueba testFindById() completada con éxito ---");
}

@Test
public void testSave() {
    System.out.println("\n--- Ejecutando prueba testSave() ---");

    Usuario usuario = new Usuario(3, "11111111-1", "Carlos", "López", null, "carlos@email.com", "ESTUDIANTE");
    Curso curso = new Curso(4, "Física", "Profe Vera", "vera@email.com");
    CursoUsuario cursoUsuario = new CursoUsuario(null, usuario, curso, "Regular", 5.0f, 6.0f, 6.5f, 5.8f);

    when(curUsuarioRepository.save(cursoUsuario)).thenReturn(cursoUsuario);
    System.out.println("Mock configurado: save() devolverá el cursoUsuario guardado");

    CursoUsuario guardado = curUsuarioService.save(cursoUsuario);
    System.out.println("Se invocó cursoUsuarioService.save()");
    System.out.println("Objeto guardado: " + guardado);

    assertNotNull(guardado, "El objeto guardado no debería ser nulo");
    assertEquals("Regular", guardado.getAnotaciones(), "La anotación debería coincidir");
    System.out.println("✓ Verificación exitosa: El objeto fue guardado correctamente");

    System.out.println("--- Prueba testSave() completada con éxito ---");
}

@Test
public void testDeleteById() {
    System.out.println("\n--- Ejecutando prueba testDeleteById() ---");

    int id = 1;
    long numeroLong=id;

    doNothing().when(curUsuarioRepository).deleteById(numeroLong);
    System.out.println("Mock configurado: deleteById(" + id + ") no hará nada");

    curUsuarioService.delete(numeroLong);
    System.out.println("Se invocó cursoUsuarioService.deleteById(" + id + ")");

    verify(curUsuarioRepository, times(1)).deleteById(numeroLong);
    System.out.println("✓ Verificación exitosa: Se eliminó correctamente el cursoUsuario con ID " + id);

    System.out.println("--- Prueba testDeleteById() completada con éxito ---");
    }
}