package ACCESO_DATOS.entidades_y_relaciones;

import java.sql.*;

/**
 *
 * @author aleja_000
 */
public class Cotizacion {
    
        int  id_cotizacion;
	int id_vehiculo ;
	int id_usuario ;
	int id_sede ;
	Date fecha;

    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_sede() {
        return id_sede;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
	

    
}

