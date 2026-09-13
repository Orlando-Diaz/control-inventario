package uniquindio.inventarios.excepcion;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(int idProducto) {
        super("No se encontró el producto con id: " + idProducto);
    }
}