package mx.edu.utez.examen1.models.usuarios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen1.models.transacciones.Transacciones;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,length = 150)
    private String nombre;
    @Column(nullable = false,length = 150)
    private String correo_electronico;
    @Column(nullable = false, length = 150)
    private String contrasena;
    @Column(nullable = false, length = 150)
    private String wish_list;

    @OneToMany(mappedBy="usuarios")
    @JsonIgnore
    private List<Transacciones> transactions;
}
