/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.DAO;

import ACCESO_DATOS.conexion.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;
/**
 *
 * @author aleja_000
 */
public class DAOVenta {
    FachadaBD fachada;
    
    public DAOVenta(){
        fachada = new FachadaBD();
    }
     /**
     * 
     * @param repuesto
     * @return int
     * @author Juan José Varela V
     * @proposito recive un objeto Venta y lo guarda en la base de datos
     */
    public int guardarVenta(Venta venta) {
       
        String sql_guardar = "INSERT INTO venta VALUES ("
                + venta.getId_venta()+ ", "
                + venta.getId_vehiculo()+", "
                + venta.getId_usuario() + ", "
                + venta.getId_sede()+ ", '"
                + venta.getForma_pago() + "', "
                + venta.getFecha() + ", "
                + venta.getCedula_cliente() +  ", '"
                + venta.getNombre_cliente() + "', "
                + venta.getTelefono_cliente() + ")";
        int numFilas = -1;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            fachada.closeConection();
        }
        catch(SQLException e){ 
            return -2; 
        }
        catch(Exception e){ 
            return -3; 
        }
        return numFilas;
    
    }
    
    public Venta consultarVenta() {
        return null;
    }
}
