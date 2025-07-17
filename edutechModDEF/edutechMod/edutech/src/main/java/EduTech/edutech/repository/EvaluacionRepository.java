package EduTech.edutech.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EduTech.edutech.model.Evaluacion;

import java.util.Date;
import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long>  {
    List<Evaluacion> findByFechaPrueba(Date fechaPrueba);
    List<Evaluacion> findByCursoPrueba(String cursoPrueba);
    List<Evaluacion> findByPorcentaje(Integer porcentaje);
}
