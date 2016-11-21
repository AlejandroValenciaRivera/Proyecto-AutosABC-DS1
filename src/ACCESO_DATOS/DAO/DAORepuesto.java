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
public class DAORepuesto {
    FachadaBD fachada;
    
    public DAORepuesto(){
        fachada = new FachadaBD();
    }
    /**
     * 
     * @param repuesto
     * @return int
     * @author Erik Lopez P
     * @proposito recive un objeto Repuesto y lo guarda en la base de datos
     */
    public int guardarRepuesto(Repuesto repuesto){
        String sql_guardar = "INSERT INTO repuestos VALUES ("
                + repuesto.getId_repuesto() + ", "
                + repuesto.getId_sede() +", '"
                + repuesto.getNombre() + "', "
                + repuesto.getCantidad() + ", "
                + repuesto.getPrecio_unidad() + ", "
                + repuesto.getIva() + ", '"
                + repuesto.getDescripcion() + "')";
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
     * @param idRep
     * @return Repuesto
     * @author Erik Lopez Pacheco
     * @proposito busca un repuesto en la base de datos y lo retorna
     */
    public Repuesto consultarRepuesto(int idRep){
        Repuesto rep = new Repuesto();
        String unRep = "SELECT id_repuesto, "
                + "id_sede, "
                + "nombre, "
                + "cantidad, "
                + "precio_unidad, "
                + "iva, "
                + "descripcion "
                + "FROM repuestos WHERE id_repuesto = " + idRep;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(unRep);
            
            rep.setId_repuesto(tabla.getInt(1));
            rep.setId_sede(tabla.getInt(2));
            rep.setNombre(tabla.getString(3));
            rep.setCantidad(tabla.getInt(4));
            rep.setPrecio_unidad(tabla.getInt(5));
            rep.setIva(tabla.getInt(6));
            rep.setDescripcion(tabla.getString(7));
            
            fachada.closeConection();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        return rep;
    }
    
}
