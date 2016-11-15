
package ACCESO_DATOS.entidades_y_relaciones;

/**
 *
 * @author aleja_000
 */
public class OrdenDeTrabajo {
        int  id_orden ;
	Usuario id_usuario;
	Repuesto id_repuesto;
	Vehiculo id_vehiculo ;
        Sede id_sede ;
	String descripcion ;

    public int getId_orden() {
        return id_orden;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public Repuesto getId_repuesto() {
        return id_repuesto;
    }

    public Vehiculo getId_vehiculo() {
        return id_vehiculo;
    }

    public Sede getId_sede() {
        return id_sede;
    }

 

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_repuesto(Repuesto id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setId_vehiculo(Vehiculo id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public void setId_sede(Sede id_sede) {
        this.id_sede = id_sede;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
        
  
}
