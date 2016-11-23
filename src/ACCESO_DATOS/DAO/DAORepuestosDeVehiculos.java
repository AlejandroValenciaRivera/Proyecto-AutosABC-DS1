/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.DAO;

import ACCESO_DATOS.conexion.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Erik Lopez Pacheco
 */
public class DAORepuestosDeVehiculos {
    FachadaBD fachada;
    
    public DAORepuestosDeVehiculos(){
        fachada = new FachadaBD();
    }
    
    /**
     * 
     * @param vinculacion
     * @return int
     * @proposito guardar en la base de datos el registor de una vinculacion que recive como parametro
     */
    public int guardarVinculacion(RepuestosDeVehiculos vinculacion){
        String statement_save = "INSERT INTO repuestos_vehiculos VALUES ("
                +vinculacion.getId_repuesto() +", "
                + vinculacion.getId_vehiculo()+" )";
        int numFilas = -1;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(statement_save);
            conn.close();
            fachada.closeConection();
        }
        catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }
    
    /**
     * 
     * @param id_vehiculo
     * @return ArrayList<RespuestosDeVechiculos> *
     * @proposito dado un id de vehiculo retorna un array de objeto RespuestosDeVehoculos asociados a ese id de vehiculo
     */
    public ArrayList<RepuestosDeVehiculos> consultarVinculacionVehiculo(int id_vehiculo){
        ArrayList<RepuestosDeVehiculos> listaVinculacion = new ArrayList<>();
        String sql_select = "SELECT * FROM repuestos_vehiculos WHERE id_vehiculo = " + id_vehiculo;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                RepuestosDeVehiculos repVehi = new RepuestosDeVehiculos();
                 repVehi.setId_repuesto(tabla.getInt(1));
                 repVehi.setId_vehiculo(tabla.getInt(2));
                 
                 listaVinculacion.add(repVehi);
                
            }
        }
        catch(SQLException e){ 
             JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);         }
         catch(Exception e){ 
             JOptionPane.showMessageDialog(null, " Conexion con la base de datos fallida. \n Contacte inmediatamente con soporte");
         }
        return listaVinculacion;
    }
    
    public ArrayList<RepuestosDeVehiculos> consultarVinculacionRepuesto(int id_repuesto){
        ArrayList<RepuestosDeVehiculos> listaVinculacion = new ArrayList<>();
        String sql_select = "SELECT * FROM repuestos_vehiculos WHERE id_repuesto = " + id_repuesto;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                RepuestosDeVehiculos repVehi = new RepuestosDeVehiculos();
                 repVehi.setId_repuesto(tabla.getInt(1));
                 repVehi.setId_vehiculo(tabla.getInt(2));
                 
                 listaVinculacion.add(repVehi);
                
            }
        }
        catch(SQLException e){ 
             JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);         }
         catch(Exception e){ 
             JOptionPane.showMessageDialog(null, " Conexion con la base de datos fallida. \n Contacte inmediatamente con soporte");
         }
        return listaVinculacion;
    }
}
