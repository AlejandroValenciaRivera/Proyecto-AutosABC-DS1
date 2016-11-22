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
public class DAOOrdenDeTrabajo {
    FachadaBD fachada;
    
    public DAOOrdenDeTrabajo(){
        fachada = new FachadaBD();
    }
    
    /**
     * 
     * @param ordenDeTrabajo
     * @return int
     * @author Erick Steven Garcia
     * @proposito recibe un objeto OrdenDeTrabajo y lo guarda en la base de datos
     */
    public int guardarOrdenDeTrabajo(OrdenDeTrabajo ordenDeTrabajo) {
       
        String sql_guardar = "INSERT INTO orden_de_trabajo VALUES ("
                + ordenDeTrabajo.getId_usuario()+", "
                + ordenDeTrabajo.getId_repuesto() + ", "
                + ordenDeTrabajo.getId_vehiculo()+ ", '"
                + ordenDeTrabajo.getId_sede() + "', "
                + ordenDeTrabajo.getDescripcion() + ") ";
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
}
