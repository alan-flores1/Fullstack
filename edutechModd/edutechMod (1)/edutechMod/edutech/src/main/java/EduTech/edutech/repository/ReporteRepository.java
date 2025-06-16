package EduTech.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EduTech.edutech.model.Reporte;

import java.util.Date;
import java.util.List;

@Repository

public interface ReporteRepository extends JpaRepository<Reporte, Long> {
    List<Reporte> findById(Integer id);
    List<Reporte> findByTipoIncidencia(String tipoIncidencia);
    List<Reporte> findByfechaReporte(Date fechaReporte);
}
