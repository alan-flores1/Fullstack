package EduTech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EduTech.edutech.model.CursoUsuario;
import EduTech.edutech.repository.CurUsuarioRepository;


@Service


public class CurUsuarioService {
    
    @Autowired
    private CurUsuarioRepository cursoUsuarioRepository;

    public List<CursoUsuario> findAll() {
        return cursoUsuarioRepository.findAll();
    }

    public CursoUsuario findById(long id) {
        return cursoUsuarioRepository.findById(id).orElse(null);
    }

    public CursoUsuario save(CursoUsuario cursoUsuario) {
        return cursoUsuarioRepository.save(cursoUsuario);
    }
    public void delete(Long id) {
        cursoUsuarioRepository.deleteById(id);
    }
}
