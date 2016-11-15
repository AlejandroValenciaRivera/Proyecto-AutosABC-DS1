package ACCESO_DATOS.entidades_y_relaciones;
import java.sql.*;
/**
 *
 * @author aleja_000
 */
public class Venta {
    
        int id_venta ;
	Vehiculo id_vehiculo ;
	Usuario id_usuario ;
	Sede id_sede ;
	int precio ;
	int iva ;
	Usuario cedula_cliente;
	String placa_vehiculo;
	Date fecha;

    public int getId_venta() {
        return id_venta;
    }

    public Vehiculo getId_vehiculo() {
        return id_vehiculo;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public Sede getId_sede() {
        return id_sede;
    }

    public int getPrecio() {
        return precio;
    }

    public int getIva() {
        return iva;
    }

    public Usuario getCedula_cliente() {
        return cedula_cliente;
    }

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public void setId_vehiculo(Vehiculo id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_sede(Sede id_sede) {
        this.id_sede = id_sede;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public void setCedula_cliente(Usuario cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
