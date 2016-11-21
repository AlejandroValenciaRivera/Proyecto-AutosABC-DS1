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
public class DAOCotizacion {
    FachadaBD fachada;
    
    public DAOCotizacion(){
        fachada = new FachadaBD();
    }
    /**
     * 
     * @param cotizacion
     * @return int
     * @author Juan José Varela V
     * @proposito recibe un objeto cotizacion y lo guarda en la base de datos
     */
    public int guardarCotizacion(Cotizacion cotizacion){
        String sql_guardar = "INSERT INTO cotizacion VALUES ("
                + cotizacion.getId_cotizacion()+ ", "
                + cotizacion.getId_vehiculo()+", "
                + cotizacion.getId_usuario() + ", "
                + cotizacion.getId_sede()+ ", "
                + cotizacion.getFecha() + ")";
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
     * @param idCotizacion
     * @return Cotizacion
     * @author Juan José Varela V
     * @proposito recibe un id_cotizacion, realiza la consulta en la base de datos
     *            y retorna un objeto cotizacion
     */
    public Cotizacion consultarCotizacion(int idCotizacion){
        Cotizacion cot = new Cotizacion();
        String unRep = "SELECT id_cotizacion, "
                + "id_vehiculo,"
                + "id_usuario,"
                + "id_sede, "
                + "fecha, "
                + "FROM cotizacion WHERE id_cotizacion = " + idCotizacion;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(unRep);
            
            cot.setId_cotizacion(tabla.getInt(1));
            cot.setId_vehiculo(tabla.getInt(2));
            cot.setId_usuario(tabla.getInt(3));
            cot.setId_sede(tabla.getInt(4));
            cot.setFecha(tabla.getDate(5));
            
            fachada.closeConection();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        return cot;
    }
    /**
     * 
     * @param cotizacion
     * @return int
     * @author Juan José Varela V
     * @proposito recibe un objeto cotizacion y guarda en la base de datos
     *            las modificaciones que se realicen
     */
    public int update(Cotizacion cotizacion){
        String update_statement = "UPDATE cotizacion SET id_vehiculo = " + cotizacion.getId_vehiculo()
                + ", id_usuario = " + cotizacion.getId_usuario()
                + ", id_sede = " + cotizacion.getId_sede()
                + ", fecha = " + cotizacion.getFecha()
                + " WHERE id_cotizacion = " + cotizacion.getId_cotizacion();
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
