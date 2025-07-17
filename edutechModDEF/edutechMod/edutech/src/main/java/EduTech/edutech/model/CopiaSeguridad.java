package EduTech.edutech.model;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;    

@Entity
@Table(name = "copias_seguridad")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CopiaSeguridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreCopia;

    @Column(nullable = false)
    private Date fechaCopia;

    @Column(nullable = false)
    private String peso;

}
