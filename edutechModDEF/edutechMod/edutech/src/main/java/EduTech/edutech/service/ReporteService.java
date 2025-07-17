package EduTech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EduTech.edutech.model.Reporte;
import EduTech.edutech.repository.ReporteRepository;


@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> findAll() {
        return reporteRepository.findAll();
    }

    public Reporte findById(long id) {
        return reporteRepository.findById(id).get();
    }

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }
    public void delete(Long id) {
        reporteRepository.deleteById(id);
    }
}
