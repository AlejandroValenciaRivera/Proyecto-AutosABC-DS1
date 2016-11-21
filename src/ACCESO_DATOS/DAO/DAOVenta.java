/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.DAO;

import ACCESO_DATOS.conexion.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;
import javax.swing.JOptionPane;
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
     * @param venta
     * @return int
     * @author Juan José Varela V
     * @proposito recibe un objeto Venta y lo guarda en la base de datos
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
     /**
     * 
     * @param idVenta
     * @return venta
     * @author Juan José Varela V
     * @proposito recibe un id Venta, realiza la consulta en la base de datos y devuelve un objeto venta
     */   
    public Venta consultarVenta(int idVenta) {

        Venta ven = new Venta();
        String unRep = "SELECT id_venta, "
                + "id_vehiculo,"
                + "id_usuario,"
                + "id_sede, "
                + "formaDePago, "
                + "fecha, "
                + "cedula_cliente, "
                + "nombre_cliente, "
                + "telefono_cliente "
                + "FROM repuestos WHERE id_repuesto = " + idVenta;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(unRep);
            
            ven.setId_venta(tabla.getInt(1));
            ven.setId_vehiculo(tabla.getInt(2));
            ven.setId_usuario(tabla.getInt(3));
            ven.setId_sede(tabla.getInt(4));
            ven.setForma_pago(tabla.getString(5));
            ven.setFecha(tabla.getDate(6));
            ven.setCedula_cliente(tabla.getInt(7));
            ven.setNombre_cliente(tabla.getString(8));
            ven.setTelefono_cliente(tabla.getInt(9));
            
            fachada.closeConection();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        return ven;
    }
     /**
     * 
     * @param Venta
     * @return int
     * @author Juan José Varela V
     * @proposito metodo que modifica registros en la base de datos
     *              a partir de un objeto venta que se recibe
     */   
    public int update(Venta venta){
        String update_statement = "UPDATE venta SET id_vehiculo = " + venta.getId_vehiculo()
                + ", id_usuario = " + venta.getId_usuario()
                + ", id_sede = " + venta.getId_sede()
                + ", formaDePago = " + venta.getForma_pago()
                + ", fecha = " + venta.getFecha()
                + " WHERE id_venta = " + venta.getId_venta();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }
    
}
