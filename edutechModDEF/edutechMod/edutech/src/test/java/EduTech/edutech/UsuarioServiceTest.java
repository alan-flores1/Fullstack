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

import EduTech.edutech.model.Usuario;
import EduTech.edutech.repository.UsuarioRepository;
import EduTech.edutech.service.UsuarioService;


import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")

@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.sql.init.mode=never"
})

public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setup() {
        System.out.println("\n=== Preparando entorno de prueba UsuarioService ===");
    }

    @Test
    public void testFindAll() {
        System.out.println("\n--- Ejecutando prueba testFindAll() ---");

        Usuario usuario = new Usuario(1, "12345678-9", "Juan", "Pérez", null, "juan@email.com", "ESTUDIANTE");
        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));
        System.out.println("Mock configurado: findAll() devolverá una lista con 1 usuario");

        List<Usuario> lista = usuarioService.findAll();
        System.out.println("Se invocó usuarioService.findAll()");
        System.out.println("Resultado obtenido: " + lista);

        assertNotNull(lista, "La lista de usuarios no debería ser nula");
        assertEquals(1, lista.size(), "Debería haber exactamente 1 usuario en la lista");
        System.out.println("✓ Verificación exitosa: La lista contiene 1 usuario");

        System.out.println("--- Prueba testFindAll() completada con éxito ---");
    }

    @Test
    public void testFindById() {
        System.out.println("\n--- Ejecutando prueba testFindById() ---");

        Integer id = 1;
        long numeroLong = id;
        Usuario usuario = new Usuario(id, "98765432-1", "Ana", "García", null, "ana@email.com", "ESTUDIANTE");

        when(usuarioRepository.findById(numeroLong)).thenReturn(Optional.of(usuario));
        System.out.println("Mock configurado: findById(" + id + ") devolverá un usuario");

        Usuario encontrado = usuarioService.findById(id);
        System.out.println("Se invocó usuarioService.findById(" + id + ")");
        System.out.println("Usuario encontrado: " + encontrado);

        assertNotNull(encontrado, "El usuario no debería ser nulo");
        assertEquals(id, encontrado.getIdUsuario(), "El ID del usuario debería coincidir");
        System.out.println("✓ Verificación exitosa: El ID coincide correctamente");

        System.out.println("--- Prueba testFindById() completada con éxito ---");
    }

    @Test
    public void testSave() {
        System.out.println("\n--- Ejecutando prueba testSave() ---");

        Usuario usuario = new Usuario(20, "00111111-1", "Carlos", "López", null, "carlos@email.com", "ESTUDIANTE");

        when(usuarioRepository.save(usuario)).thenReturn(usuario);
        System.out.println("Mock configurado: save() devolverá el usuario guardado");

        Usuario guardado = usuarioService.save(usuario);
        System.out.println("Se invocó usuarioService.save()");
        System.out.println("Usuario guardado: " + guardado);

        assertNotNull(guardado, "El usuario guardado no debería ser nulo");
        assertEquals("Carlos", guardado.getNombres(), "El nombre del usuario debería coincidir");
        System.out.println("✓ Verificación exitosa: El usuario se guardó correctamente");

        System.out.println("--- Prueba testSave() completada con éxito ---");
    }

    @Test
    public void testDeleteById() {
        System.out.println("\n--- Ejecutando prueba testDeleteById() ---");

        Integer id = 20;
        long numeroLong = id;
        doNothing().when(usuarioRepository).deleteById(numeroLong);
        System.out.println("Mock configurado: deleteById(" + id + ") no hará nada");

        usuarioService.delete(numeroLong);
        System.out.println("Se invocó usuarioService.delete(" + id + ")");

        verify(usuarioRepository, times(1)).deleteById(numeroLong);
        System.out.println("✓ Verificación exitosa: Se eliminó el usuario con ID " + id);

        System.out.println("--- Prueba testDeleteById() completada con éxito ---");
    }
}

    
