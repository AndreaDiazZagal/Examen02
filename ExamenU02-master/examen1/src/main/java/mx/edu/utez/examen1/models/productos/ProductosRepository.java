package mx.edu.utez.examen1.models.productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {

    boolean existsByNombre(String nombre);

}
