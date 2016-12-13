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
                usu.getSede() +  ", '" +
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
            return numFilas;
        }
        catch(SQLException e){ 
            return -2; 
        }
        catch(Exception e){ 
            return -3; 
        }
        
    }
    
    public Usuario ConsultarUsuario(int cedula){
        Usuario user = new Usuario();
        
        String sql_select;
        sql_select="SELECT * FROM  usuarios WHERE cedula =" + cedula;
         try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
               user = new Usuario();
               
               user.setCedula(tabla.getInt(1));
               
               user.setSede(tabla.getInt(2));
               
               user.setNombre(tabla.getString(3));
               
               user.setFecha(tabla.getDate(4));
               
               user.setDireccion(tabla.getString(5));
               
               user.setGenero(tabla.getString(6).charAt(0));
               
               user.setEmail(tabla.getString(7));
               
               user.setCargo(tabla.getInt(8));
               
               user.setTelefono(tabla.getString(10));             

            }

            fachada.closeConection();
         }
         catch(SQLException e){ 
             JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, \n consulta con la base de datos fallida");
         }
         catch(Exception e){ 
             JOptionPane.showMessageDialog(null, " Conexion con la base de datos fallida. \n Contacte inmediatamente con soporte");
         }
         
        return user;
    }
    
    public ArrayList<Usuario> consultarLogin(){
        
        Usuario user;
        ArrayList<Usuario> users = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT cuenta,contrasena,cargo, id_sede, cedula FROM  usuarios";
         try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
               user = new Usuario();
               
               user.setCuenta(tabla.getString(1));
              
               user.setContrasena(tabla.getString(2));
               
               user.setCargo(tabla.getInt(3));
               
               user.setSede(tabla.getInt(4));
               
               user.setCedula(tabla.getInt(5));

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
    
    public ArrayList<Usuario> consultarUsuarios(){
        
        Usuario user;
        ArrayList<Usuario> users = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT * FROM  usuarios";
         try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
               user = new Usuario();
               
               user.setCedula(tabla.getInt(1));
              
               user.setSede(tabla.getInt(2));
               
               user.setNombre(tabla.getString(3));
               
               user.setFecha(tabla.getDate(4));
               
               user.setDireccion(tabla.getString(5));
               
               user.setGenero(tabla.getString(6).charAt(0));
               
               user.setEmail(tabla.getString(7));
               
               user.setCargo(tabla.getInt(8));
               
               user.setSalario(tabla.getInt(9));
               
               user.setTelefono(tabla.getString(10));
               
               user.setEstado(tabla.getString(11));
               
               user.setCuenta(tabla.getString(12));
               
               user.setContrasena(tabla.getString(13));

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
    
    public int updateNombre(Usuario usuario) {
        String update_statement = "UPDATE usuarios SET nombre = '" + usuario.getNombre() + "' WHERE cedula = " + usuario.getCedula();
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
    
    public int updateDireccion(Usuario usuario) {
        String update_statement = "UPDATE usuarios SET direccion = '" + usuario.getDireccion() + "' WHERE cedula = " + usuario.getCedula();
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
    
    public int updateEmail(Usuario usuario) {
        String update_statement = "UPDATE usuarios SET e_mail = '" + usuario.getEmail() + "' WHERE cedula = " + usuario.getCedula();
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
    
    public int updateTelefono(Usuario usuario) {
        String update_statement = "UPDATE usuarios SET telefono = '" + usuario.getTelefono() + "' WHERE cedula = " + usuario.getCedula();
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
    
    public int updateSede(Usuario usuario) {
        String update_statement = "UPDATE usuarios SET id_sede = '" + usuario.getSede() + "' WHERE cedula = " + usuario.getCedula();
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
    
    public int updateEstado(Usuario usuario) {
        String update_statement = "UPDATE usuarios SET estado = '" + usuario.getEstado() + "' WHERE cedula = " + usuario.getCedula();
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
    
    public int updateSalario(Usuario usuario) {
        String update_statement = "UPDATE usuarios SET salario = '" + usuario.getSalario() + "' WHERE cedula = " + usuario.getCedula();
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
    
    public int updateUsuANDpass(Usuario usuario) {
        String update_statement  = "UPDATE usuarios SET cuenta = '" + usuario.getCuenta() + "' WHERE cedula = " + usuario.getCedula();
        String update_statement2 = "UPDATE usuarios SET contrasena = '" + usuario.getContrasena() + "' WHERE cedula = " + usuario.getCedula();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            numFilas = sentencia.executeUpdate(update_statement2);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return -2;
        } catch (Exception ex) {
            System.out.println("11 --" + ex);
            return -3;
        }
        
    }
}
