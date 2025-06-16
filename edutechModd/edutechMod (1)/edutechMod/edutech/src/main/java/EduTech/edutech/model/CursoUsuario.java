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

    @Column(unique = false, nullable = false )
    private Integer idCurso;

    @Column(unique = false, nullable = false )
    private Integer idUsuario;

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




