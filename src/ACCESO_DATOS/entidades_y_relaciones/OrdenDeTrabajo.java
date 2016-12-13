
package ACCESO_DATOS.entidades_y_relaciones;

/**
 *
 * @author aleja_000
 */
public class OrdenDeTrabajo {
        int id_orden ;
	int id_usuario;
	int id_repuesto;
	int id_vehiculo ;
        int id_sede ;
        int cantidad_repuesto;
	String descripcion ;

    public int getId_orden() {
        return id_orden;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public int getId_sede() {
        return id_sede;
    }
    
    public int getCantidadRepuesto() {
        return cantidad_repuesto;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setCantidadRepuesto(int cantidad_repuesto) {
        this.cantidad_repuesto = cantidad_repuesto;
    }
        
  
}
