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
public class DAOSede {
    FachadaBD fachada;
    
    public DAOSede() {
        fachada = new FachadaBD();
    }
    
    public int guardarSede(Sede sede) {
        String sql_guardar;
        sql_guardar="INSERT INTO sedes VALUES (" +
                sede.getId() + ", '" + 
                sede.getNombre() +  "', '" +
                sede.getCiudad() + "', '"  +
                sede.getDireccion() + "', '" +
                sede.getTelefono() + "' , '" +
                sede.getFax() + "')";
        int numFilas = -1;
        try{
            Connection conn= fachada.getConnetion();
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
    
    public Sede consultarSede(int id_sede) {
        return null;
    }
    
    public ArrayList<Sede> consultarSedes() {
        Sede unaSede;
        ArrayList<Sede> sedes = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT * FROM  sedes";
         try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
               unaSede = new Sede();
               
               unaSede.setId(tabla.getInt(1));
              
               unaSede.setNombre(tabla.getString(2));
               unaSede.setCiudad(tabla.getString(3));
               unaSede.setDireccion(tabla.getString(4));
               unaSede.setTelefono(tabla.getString(5));
               unaSede.setFax(tabla.getString(6));
               

               sedes.add(unaSede);
            }

            fachada.closeConection();
            //return sedes;
         }
         catch(SQLException e){ 
             JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);         }
         catch(Exception e){ 
             JOptionPane.showMessageDialog(null, " Conexion con la base de datos fallida. \n Contacte inmediatamente con soporte");
         }
         
        return sedes;
    }
    
    public int updateNombre(Sede sede) {
        String update_statement = "UPDATE sedes SET nombre = '" + sede.getNombre() + "' WHERE id_sede = " + sede.getId();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }
    
    public int updateCiudad(Sede sede) {
        String update_statement = "UPDATE sedes SET ciudad = '" + sede.getCiudad() + "' WHERE id_sede = " + sede.getId();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }
    
    public int updateDireccion(Sede sede) {
        String update_statement = "UPDATE sedes SET direccion = '" + sede.getDireccion() + "' WHERE id_sede = " + sede.getId();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }
    
    public int updateTelefono(Sede sede) {
        String update_statement = "UPDATE sedes SET telefono = '" + sede.getTelefono() + "' WHERE id_sede = " + sede.getId();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }
    
    public int updateFax(Sede sede) {
        String update_statement = "UPDATE sedes SET fax = '" + sede.getFax() + "' WHERE id_sede = " + sede.getId();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }
}
