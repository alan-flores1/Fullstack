package EduTech.edutech;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import EduTech.edutech.model.CopiaSeguridad;
import EduTech.edutech.repository.CopiaRepository;
import EduTech.edutech.service.CopiaService;

@SpringBootTest
@ActiveProfiles("test")


@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=none",
    "spring.sql.init.mode=never"
})

public class CopiaServiceTest {
    
    @Autowired
    private CopiaService copiaService;

    @MockBean
    private CopiaRepository copiaRepository;

    @Test
    public void testFindAll() {
        System.out.println("\n--- Ejecutando prueba testFindAll() ---");

        Timestamp fecha = Timestamp.valueOf("2025-06-03 02:07:48.534000000");
        CopiaSeguridad copia = new CopiaSeguridad(1, "copia_03junio.zip", fecha, "50MB");
        when(copiaRepository.findAll()).thenReturn(List.of(copia));
        System.out.println("Mock configurado: findAll() devolverá una lista con 1 copia");

        List<CopiaSeguridad> lista = copiaService.findAll();
        System.out.println("Se invocó CopiaService.findAll()");
        System.out.println("Resultado obtenido: " + lista);

        assertNotNull(lista, "La lista no debería ser nula");
        assertEquals(1, lista.size(), "Debería haber exactamente 1 copia en la lista");
        System.out.println("✓ Verificación exitosa: La lista contiene 1 copia");

        System.out.println("--- Prueba testFindAll() completada ---");
    }

    @Test
    public void testFindById() {
        System.out.println("\n--- Ejecutando prueba testFindById() ---");
        int codigo= 1;
        long id = codigo;
        Timestamp fecha = Timestamp.valueOf("2025-06-03 02:07:48.534000000");
        CopiaSeguridad copia = new CopiaSeguridad(1, "copia_mayo.zip", fecha, "35MB");

        when(copiaRepository.findById(id)).thenReturn(Optional.of(copia));
        System.out.println("Mock configurado: findById() devolverá una copia con ID " + id);

        CopiaSeguridad encontrado = copiaService.findById(id);
        System.out.println("Se invocó copiaService.findById(" + id + ")");
        System.out.println("Objeto encontrado: " + encontrado);

        assertNotNull(encontrado, "La Copia no debería ser nulo");
        assertEquals(codigo, encontrado.getId(), "El ID debería coincidir");

        System.out.println("✓ Verificación exitosa: El ID coincide correctamente");

        System.out.println("--- Prueba testFindById() completada ---");
    }

    @Test
    public void testSave() {
        System.out.println("\n--- Ejecutando prueba testSave() ---");
        Timestamp fecha = Timestamp.valueOf("2025-06-03 02:07:48.534000000");
        CopiaSeguridad copia = new CopiaSeguridad(null, "nueva_copia.zip", fecha, "40MB");
        when(copiaRepository.save(copia)).thenReturn(copia);
        System.out.println("Mock configurado: save() devolverá la copia proporcionada");

        CopiaSeguridad guardada = copiaService.save(copia);
        System.out.println("Copia guardada: " + guardada);

        assertNotNull(guardada, "La copia guardada no debería ser nula");
        assertEquals("nueva_copia.zip", guardada.getNombreCopia(), "El nombre debería coincidir");
        System.out.println("✓ Verificación exitosa: El objeto fue guardado correctamente");

        System.out.println("--- Prueba testSave() completada ---");
    }

    @Test
    public void testDelete() {
        System.out.println("\n--- Ejecutando prueba testDelete() ---");
        int codigo=1;
        long id = codigo;
        doNothing().when(copiaRepository).deleteById(id);
        System.out.println("Mock configurado: deleteById() no hará nada con ID " + id);

        copiaService.delete(id);
        verify(copiaRepository, times(1)).deleteById(id);
        System.out.println("✓ Verificación exitosa: Se invocó deleteById una vez");

        System.out.println("--- Prueba testDelete() completada ---");
    }
}