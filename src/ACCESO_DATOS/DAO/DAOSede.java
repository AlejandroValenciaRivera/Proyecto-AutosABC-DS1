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
            
        }
        catch(SQLException e){ 
            return -2; 
        }
        catch(Exception e){ 
            return -3; 
        }
        return numFilas;
    }
    
    public Sede consultarSede(int id_sede) {
        return null;
    }
}
