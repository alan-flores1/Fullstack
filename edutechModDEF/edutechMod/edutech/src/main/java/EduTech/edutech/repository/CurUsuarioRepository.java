package EduTech.edutech.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EduTech.edutech.model.CursoUsuario;

import java.util.List;

@Repository


public interface CurUsuarioRepository extends JpaRepository<CursoUsuario, Long>  {
    List<CursoUsuario> findByIdCursoUsuario(long id);
    List<CursoUsuario> findByCurso_Idcurso(Integer idCurso);
    List<CursoUsuario> findByUsuario_idUsuario(Integer idUsuario);
}
