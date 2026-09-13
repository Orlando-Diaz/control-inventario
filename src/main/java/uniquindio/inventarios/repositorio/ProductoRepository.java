package uniquindio.inventarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniquindio.inventarios.modelo.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Spring Data JPA genera la consulta automáticamente por el nombre del método
    List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);

    List<Producto> findByExistenciaLessThan(int cantidad);
}