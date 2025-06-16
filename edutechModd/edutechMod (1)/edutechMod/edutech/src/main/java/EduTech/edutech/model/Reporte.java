package EduTech.edutech.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;    

import java.util.Date;

@Entity
@Table(name = "reporte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fechaReporte;

    @Column(nullable = false)
    private String tipoIncidencia;

}

