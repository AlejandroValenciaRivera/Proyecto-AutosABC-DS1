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
public class DAORepuesto {
    FachadaBD fachada;
    
    public DAORepuesto(){
        fachada = new FachadaBD();
    }
    
    public int guardarRepuesto(Repuesto repuesto){
        return 1;
    }
    
    public Repuesto consultarRepuesto(){
        return null;
    }
    
}
