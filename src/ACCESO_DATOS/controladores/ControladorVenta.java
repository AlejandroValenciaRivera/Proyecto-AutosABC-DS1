/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.controladores;

import ACCESO_DATOS.DAO.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;
/**
 *
 * @author aleja_000
 */
public class ControladorVenta {
    DAOVenta daoVenta;
    
    public ControladorVenta(){
        daoVenta = new DAOVenta();
    }
    
    public int insertarVenta(){
        return 1;
    }
}
