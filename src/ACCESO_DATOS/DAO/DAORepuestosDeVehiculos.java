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
 * @author Erik Lopez Pacheco
 */
public class DAORepuestosDeVehiculos {
    FachadaBD fachada;
    
    public DAORepuestosDeVehiculos(){
        fachada = new FachadaBD();
    }
    
    public int guardarVinculacion(RepuestosDeVehiculos vinculacion){
        String statement_save = "INSERT INTO repuestos_vehiculos VALUES ("
                +vinculacion.getId_repuesto() +", "
                + vinculacion.getId_vehiculo()+" )";
        int numFilas = -1;
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(statement_save);
            conn.close();
            fachada.closeConection();
        }
        catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }
    
    public RepuestosDeVehiculos consultarVinculacion(){
        return null;
    }
}
