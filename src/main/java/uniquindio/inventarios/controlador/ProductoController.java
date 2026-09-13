package uniquindio.inventarios.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniquindio.inventarios.modelo.Producto;
import uniquindio.inventarios.servicio.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto creado = productoService.crear(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable("id") int idProducto) {
        return ResponseEntity.ok(productoService.obtenerPorId(idProducto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable("id") int idProducto,
                                               @RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.actualizar(idProducto, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int idProducto) {
        productoService.eliminar(idProducto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarPorDescripcion(@RequestParam String descripcion) {
        return ResponseEntity.ok(productoService.buscarPorDescripcion(descripcion));
    }

    @GetMapping("/baja-existencia")
    public ResponseEntity<List<Producto>> obtenerConBajaExistencia(@RequestParam int cantidad) {
        return ResponseEntity.ok(productoService.obtenerConBajaExistencia(cantidad));
    }
}