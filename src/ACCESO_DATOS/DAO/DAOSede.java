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
}
