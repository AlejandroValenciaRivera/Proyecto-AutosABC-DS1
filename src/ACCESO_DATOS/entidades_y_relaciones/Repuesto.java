
package ACCESO_DATOS.entidades_y_relaciones;

/**
 *
 * @author aleja_000
 */
public class Repuesto {
    
        int id_repuesto;
	int id_sede ;
	String nombre ;
	int cantidad;
	int precio_unidad ;
	int iva;
	String descripcion ;

    public int getId_repuesto() {
        return id_repuesto;
    }

    public int getId_sede() {
        return id_sede;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio_unidad() {
        return precio_unidad;
    }

    public int getIva() {
        return iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio_unidad(int precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	
    
       
    
    
    
}
