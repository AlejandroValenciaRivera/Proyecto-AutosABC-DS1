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
                + "nextval('secuencia_id_venta'), "
                + venta.getId_vehiculo()+", "
                + venta.getId_usuario() + ", "
                + venta.getId_sede()+ ", '"
                + venta.getForma_pago() + "', "
                + "now(), '"
                + venta.getCedula_cliente() +  "', '"
                + venta.getNombre_cliente() + "', '"
                + venta.getTelefono_cliente() + "')";
        int numFilas = -1;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            fachada.closeConection();
            return numFilas;
        }
        catch(SQLException e){ 
            return -2; 
        }
        catch(Exception e){ 
            return -3; 
        }
        
    
    }
     /**
     * 
     * @param idVenta
     * @return venta
     * @author Juan José Varela V
     * @proposito recibe un id Venta, realiza la consulta en la base de datos y devuelve un objeto venta
     */   
    public int consultarVentaReciente() {

        Venta ven = new Venta();
        String unRep = "SELECT * FROM venta";
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(unRep);
            
            int numFilas = 0;
            while(tabla.next()){
                numFilas++;
            }
            conn.close();
            fachada.closeConection();
            return numFilas;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE); 
            return -2;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
            return -3;
        }
    }
}
