package EduTech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EduTech.edutech.model.Curso;
import EduTech.edutech.repository.CursoRepository;


@Service

public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(long id) {
        return cursoRepository.findById(id).get();
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
