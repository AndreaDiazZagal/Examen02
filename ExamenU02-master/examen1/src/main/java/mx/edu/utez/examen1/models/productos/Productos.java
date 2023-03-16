package mx.edu.utez.examen1.models.productos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen1.models.transacciones.Transacciones;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,length = 150)
    private String nombre;
    @Column(nullable = false, length = 150)
    private String categoria;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Boolean disponibilidad;

    @OneToMany(mappedBy="productos")
    @JsonIgnore
    private List<Transacciones> transacciones;
}
