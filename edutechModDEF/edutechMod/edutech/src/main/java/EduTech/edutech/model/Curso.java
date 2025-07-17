package EduTech.edutech.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;    


@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String profesor;

    @Column(nullable = true)
    private String correo;

}


