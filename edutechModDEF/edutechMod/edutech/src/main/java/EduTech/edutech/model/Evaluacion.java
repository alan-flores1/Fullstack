package EduTech.edutech.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;    

import java.util.Date;


@Entity
@Table(name = "evaluacion")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String NombreEva;

    @Column(nullable = false)
    private String cursoPrueba;

    @Column(nullable = false)
    private Integer porcentaje;

    @Column(nullable = false)
    private Date fechaPrueba;

}



    

