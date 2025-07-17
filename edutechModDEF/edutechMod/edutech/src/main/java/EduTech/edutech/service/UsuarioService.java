package EduTech.edutech.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EduTech.edutech.model.Usuario;
import EduTech.edutech.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

}
