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
public class DAOCotizacion {
    FachadaBD fachada;
    
    public DAOCotizacion(){
        fachada = new FachadaBD();
    }
    
    public int guardarCotizacion(Cotizacion cotizacion){
        return 1;
    }
    
    public Cotizacion consultarCotizacion(){
        return null;
    }
}
