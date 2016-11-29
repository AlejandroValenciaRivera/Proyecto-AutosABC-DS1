package ACCESO_DATOS.entidades_y_relaciones;
import java.sql.*;
/**
 *
 * @author aleja_000
 */
public class Venta {
    
        int id_venta ;
	int id_vehiculo ;
	int id_usuario ;
	int id_sede ;
        String forma_pago;
	String cedula_cliente;
        String nombre_cliente;
        String telefono_cliente;
	Date fecha;


    public String getForma_pago() {
        return forma_pago;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public int getId_venta() {
        return id_venta;
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

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }
    
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }
}
