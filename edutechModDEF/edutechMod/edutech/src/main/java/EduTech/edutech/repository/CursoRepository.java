package EduTech.edutech.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EduTech.edutech.model.Curso;

import java.util.List;

@Repository


public interface CursoRepository extends JpaRepository<Curso, Long>  {
    List<Curso> findByNombre(String nombre);
    List<Curso> findByCorreo(String correo);
    List<Curso> findByProfesor(String profesor);
}
