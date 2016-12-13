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
                + ordenDeTrabajo.getId_orden() + ", " 
                + ordenDeTrabajo.getId_usuario()+", "
                + ordenDeTrabajo.getId_repuesto() + ", "
                + ordenDeTrabajo.getId_vehiculo()+ ", '"
                + ordenDeTrabajo.getId_sede() + "', " 
                + ordenDeTrabajo.getCantidadRepuesto() + ", '"
                + ordenDeTrabajo.getDescripcion() + "') ";
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
     * @param id_orden
     * @return OrdenDeTrabajo
     * @author Erick Steven Garcia
     * @proposito recibe un id de orden para filtrarlo
     */
    public OrdenDeTrabajo ConsultarOrden(int id_orden){
        return null;
    }
    
    /**
     * 
     * @param 
     * @return ArrayList<OrdenDeTrabajo>
     * @author Erick Steven Garcia
     * @proposito retorna todas las ordenes de trabajo
     */
    public ArrayList<OrdenDeTrabajo> consultarTodas(){
        
        OrdenDeTrabajo orden;
        ArrayList<OrdenDeTrabajo> ordenes = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT id_orden , id_usuario , id_repuesto , id_vehiculo , id_sede , cantidad_repuesto, descripcion FROM orden_de_trabajo";
         try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
               orden = new OrdenDeTrabajo();
               
               orden.setId_orden(tabla.getInt(1));
                                             
               orden.setId_usuario(tabla.getInt(2));
               
               orden.setId_repuesto(tabla.getInt(3));
               
               orden.setId_vehiculo(tabla.getInt(4));
               
               orden.setId_sede(tabla.getInt(5));
               
               orden.setCantidadRepuesto(tabla.getInt(6));
               
               orden.setDescripcion(tabla.getString(7));
               
               ordenes.add(orden);
            }

            fachada.closeConection();
            return ordenes;
         }
         catch(SQLException e){ 
             JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, \n consulta con la base de datos fallida");
         }
         catch(Exception e){ 
             JOptionPane.showMessageDialog(null, " Conexion con la base de datos fallida. \n Contacte inmediatamente con soporte");
         }
         
        return ordenes;
    }
}
