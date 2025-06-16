package EduTech.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EduTech.edutech.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByApellidos(String apellidos);
    List<Usuario> findByCorreo(String correo);
    List<Usuario> findByNombresAndApellidos(String nombres, String apellidos);
    List<Usuario> findByRol(String rol);

}

    

