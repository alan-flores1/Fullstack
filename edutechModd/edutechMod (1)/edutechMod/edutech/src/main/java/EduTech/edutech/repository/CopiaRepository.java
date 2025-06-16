package EduTech.edutech.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EduTech.edutech.model.CopiaSeguridad;

import java.util.Date;
import java.util.List;

@Repository



public interface CopiaRepository extends JpaRepository<CopiaSeguridad, Long> {

    List<CopiaSeguridad> findById(Integer id);
    List<CopiaSeguridad> findByNombreCopia(String nombreCopia);
    List<CopiaSeguridad> findByFechaCopia(Date fechaCopia);
    List<CopiaSeguridad> findByPeso(String Peso);
    
}
