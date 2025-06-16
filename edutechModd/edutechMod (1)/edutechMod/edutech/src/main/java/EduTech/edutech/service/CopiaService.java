package EduTech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EduTech.edutech.model.CopiaSeguridad;
import EduTech.edutech.repository.CopiaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CopiaService{

    @Autowired
    private CopiaRepository copiaRepository;

    public List<CopiaSeguridad> findAll() {
        return copiaRepository.findAll();
    }

    public CopiaSeguridad findById(long id) {
        return copiaRepository.findById(id).get();
    }

    public CopiaSeguridad save(CopiaSeguridad copia) {
        return copiaRepository.save(copia);
    }
    public void delete(Long id) {
        copiaRepository.deleteById(id);
    }
}
