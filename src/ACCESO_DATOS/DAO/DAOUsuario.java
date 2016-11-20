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
public class DAOUsuario {
    FachadaBD fachada;
    
    public DAOUsuario(){
        fachada = new FachadaBD(); 
    }
    
    public int GuardarUsuario(Usuario usu){
        String sql_guardar;
        sql_guardar="INSERT INTO Usuarios VALUES (" +
                usu.getCedula() + ", " + 
                usu.getSede().getId() +  ", '" +
                usu.getNombre() + "', '"  +
                usu.getFecha() + "', '" +
                usu.getDireccion() + "' , '" +
                usu.getGenero() + "' , '" +
                usu.getEmail() + "' , " +
                usu.getCargo() + ", " +
                usu.getSalario() + ", '" +
                usu.getTelefono() + "', '" + 
                usu.getEstado() + "' , '" +
                usu.getCuenta() + "', '" +
                usu.getContrasena() + "')";
        int numFilas = -1;
        try{
            Connection conn= fachada.getConnetion();
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
    
    public Usuario ConsultarUsuario(int cedula){
        return null;
    }
    
    public ArrayList<Usuario> consultarLogin(){
        
        Usuario user;
        ArrayList<Usuario> users = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT cuenta,contrasena,cargo FROM  usuarios";
         try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
               user = new Usuario();
               
               user.setCuenta(tabla.getString(1));
              
               user.setContrasena(tabla.getString(2));
               
               user.setCargo(tabla.getInt(3));

               users.add(user);
            }

            fachada.closeConection();
            return users;
         }
         catch(SQLException e){ 
             JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, \n consulta con la base de datos fallida");
         }
         catch(Exception e){ 
             JOptionPane.showMessageDialog(null, " Conexion con la base de datos fallida. \n Contacte inmediatamente con soporte");
         }
         
        return users;
    }
}
