package uniquindio.inventarios.servicio;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.inventarios.excepcion.ProductoNoEncontradoException;
import uniquindio.inventarios.modelo.Producto;
import uniquindio.inventarios.repositorio.ProductoRepository;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    // Inyección de dependencias por constructor (buena práctica sobre @Autowired en campo)
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerPorId(int idProducto) {
        return productoRepository.findById(idProducto)
                .orElseThrow(() -> new ProductoNoEncontradoException(idProducto));
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Producto actualizar(int idProducto, Producto productoActualizado) {
        Producto productoExistente = obtenerPorId(idProducto);

        productoExistente.setDescripcion(productoActualizado.getDescripcion());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setExistencia(productoActualizado.getExistencia());

        return productoRepository.save(productoExistente);
    }

    @Override
    @Transactional
    public void eliminar(int idProducto) {
        if (!productoRepository.existsById(idProducto)) {
            throw new ProductoNoEncontradoException(idProducto);
        }
        productoRepository.deleteById(idProducto);
    }

    @Override
    public List<Producto> buscarPorDescripcion(String descripcion) {
        return productoRepository.findByDescripcionContainingIgnoreCase(descripcion);
    }

    @Override
    public List<Producto> obtenerConBajaExistencia(int cantidad) {
        return productoRepository.findByExistenciaLessThan(cantidad);
    }
}