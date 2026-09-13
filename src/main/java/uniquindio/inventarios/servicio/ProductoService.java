package uniquindio.inventarios.servicio;

import uniquindio.inventarios.modelo.Producto;

import java.util.List;

public interface ProductoService {

    Producto crear(Producto producto);

    Producto obtenerPorId(int idProducto);

    List<Producto> obtenerTodos();

    Producto actualizar(int idProducto, Producto producto);

    void eliminar(int idProducto);

    List<Producto> buscarPorDescripcion(String descripcion);

    List<Producto> obtenerConBajaExistencia(int cantidad);
}