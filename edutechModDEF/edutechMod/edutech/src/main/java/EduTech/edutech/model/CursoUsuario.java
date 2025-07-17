package EduTech.edutech.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;    


@Entity
@Table(name = "curso_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCursoUsuario;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    @Column(nullable = true)
    private String Anotaciones;

    @Column(nullable = true)
    private float nota1;

    @Column(nullable = true)
    private float nota2;

    @Column(nullable = true)
    private float nota3;

    @Column(nullable = true)
    private float notaFinal;

    
}




