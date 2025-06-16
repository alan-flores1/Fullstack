package EduTech.edutech.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EduTech.edutech.model.Evaluacion;
import EduTech.edutech.repository.EvaluacionRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class EvaluacionService {
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }

    public Evaluacion findById(long id) {
        return evaluacionRepository.findById(id).get();
    }

    public Evaluacion save(Evaluacion eva) {
        return evaluacionRepository.save(eva);
    }
    public void delete(Long id) {
        evaluacionRepository.deleteById(id);
    }
}
