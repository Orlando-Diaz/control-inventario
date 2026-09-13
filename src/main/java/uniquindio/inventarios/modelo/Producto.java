package uniquindio.inventarios.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idProducto;

    String descripcion;
    double precio;
    int existencia;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String descripcion, double precio, int existencia) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
    }

    public Producto(int idProducto, String descripcion, double precio, int existencia) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", existencia=" + existencia +
                '}';
    }
}
