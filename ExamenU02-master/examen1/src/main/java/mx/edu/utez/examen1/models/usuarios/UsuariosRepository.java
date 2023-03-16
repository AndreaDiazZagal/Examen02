package mx.edu.utez.examen1.models.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
    boolean existsByNombre(String nombre);
}
