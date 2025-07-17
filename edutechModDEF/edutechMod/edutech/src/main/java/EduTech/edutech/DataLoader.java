package EduTech.edutech;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import EduTech.edutech.model.CopiaSeguridad;
import EduTech.edutech.model.Curso;
import EduTech.edutech.model.CursoUsuario;
import EduTech.edutech.model.Evaluacion;
import EduTech.edutech.model.Reporte;
import EduTech.edutech.model.Usuario;
import EduTech.edutech.repository.CopiaRepository;
import EduTech.edutech.repository.CurUsuarioRepository;
import EduTech.edutech.repository.CursoRepository;
import EduTech.edutech.repository.UsuarioRepository;
import EduTech.edutech.repository.EvaluacionRepository;
import EduTech.edutech.repository.ReporteRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Profile("!test")
@Component

public class DataLoader implements CommandLineRunner {

 @Autowired
 private CopiaRepository copiaRepository;
 @Autowired
 private ReporteRepository reporteRepository;
 @Autowired
 private UsuarioRepository usuarioRepository;
 @Autowired
 private CursoRepository cursoRepository;
 @Autowired
 private CurUsuarioRepository curUsuarioRepository;
 @Autowired
 private EvaluacionRepository evaluacionRepository;
 @Override
 public void run(String... args) throws Exception {
 Faker faker = new Faker();
 Random random = new Random();
 // Generar cursos
 for (int i = 0; i < 10; i++) {
        Curso curso = new Curso();
        curso.setNombre(faker.educator().course());
        curso.setProfesor(faker.name().fullName());
        curso.setCorreo(faker.internet().emailAddress());
        cursoRepository.save(curso);
}
 // Generar usuarios
 for (int i = 0; i < 20; i++) {
        Usuario usuario = new Usuario();
        usuario.setRun(faker.idNumber().valid());
        usuario.setNombres(faker.name().firstName());
        usuario.setApellidos(faker.name().lastName());
        usuario.setFechaNacimiento(faker.date().birthday());
        usuario.setCorreo(faker.internet().emailAddress());
        usuario.setRol(faker.job().position());
        usuarioRepository.save(usuario);
}

for (int i = 0; i < 10; i++) {
        Evaluacion eva = new Evaluacion();
        eva.setNombreEva(faker.book().title());
        eva.setCursoPrueba(faker.educator().course());
        eva.setPorcentaje(faker.number().numberBetween(10, 100));
        eva.setFechaPrueba(faker.date().future(60, java.util.concurrent.TimeUnit.DAYS));
        evaluacionRepository.save(eva);
}

 // Generar copias de Seguridad
 for (int i = 0; i < 5; i++) {
        CopiaSeguridad copia = new CopiaSeguridad();
        copia.setNombreCopia("backup_" + faker.file().fileName());
        copia.setFechaCopia(new Date());  // Correcto
        copia.setPeso(faker.number().numberBetween(10, 500) + "MB");
        copiaRepository.save(copia);
}

 // Generar reportes
 for (int i = 0; i < 10; i++) {
        Reporte rep = new Reporte();
        rep.setFechaReporte(faker.date().past(30, java.util.concurrent.TimeUnit.DAYS));
        rep.setTipoIncidencia(faker.lorem().sentence());
        reporteRepository.save(rep);
}
//Generar cursosUsuarios
List<Curso> cursos = cursoRepository.findAll();
List<Usuario> usuarios = usuarioRepository.findAll();
for (int i = 0; i < 30; i++) {
        CursoUsuario cu = new CursoUsuario();
        cu.setCurso(cursos.get(random.nextInt(cursos.size())));
        cu.setUsuario(usuarios.get(random.nextInt(usuarios.size())));
        cu.setAnotaciones(faker.lorem().sentence());
        cu.setNota1(random.nextFloat() * 7);
        cu.setNota2(random.nextFloat() * 7);
        cu.setNota3(random.nextFloat() * 7);
        cu.setNotaFinal((cu.getNota1() + cu.getNota2() + cu.getNota3()) / 3);
        curUsuarioRepository.save(cu);
     }
    };
}