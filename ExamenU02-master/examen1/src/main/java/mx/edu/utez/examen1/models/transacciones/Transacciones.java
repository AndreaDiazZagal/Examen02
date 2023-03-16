package mx.edu.utez.examen1.models.transacciones;

import lombok.*;
import mx.edu.utez.examen1.models.productos.Productos;
import mx.edu.utez.examen1.models.usuarios.Usuarios;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transacciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,length = 150)
    private Long id_usuario;
    @Column(nullable = false,length = 150)
    private Long id_product;
    @Column(nullable = false)
    private Date fecha;


    @ManyToOne
    @JoinColumn(name = "id_productos",nullable = false)
    private Productos productos;
    @ManyToOne
    @JoinColumn(name = "id_usuarios",nullable = false)
    private Usuarios usuarios;


}
