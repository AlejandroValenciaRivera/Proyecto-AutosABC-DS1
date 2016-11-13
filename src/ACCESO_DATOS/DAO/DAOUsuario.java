/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.DAO;

import ACCESO_DATOS.conexion.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;

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
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            fachada.closeConection();
            return numFilas;
        }
        catch(SQLException e){ 
            System.out.println(e); 
        }
        catch(Exception e){ 
            System.out.println(e); 
        }
        return -1;
    }
    
    public void ConsultarUsuario(Usuario e){
    
    }
}
