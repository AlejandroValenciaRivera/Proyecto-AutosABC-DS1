/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.controladores;

import ACCESO_DATOS.DAO.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author aleja_000
 */
public class ControladorCotizacion {
    DAOCotizacion daoCotizacion;
    
    public ControladorCotizacion(){
        daoCotizacion = new DAOCotizacion();
    }
    
    public int insertarCotizacion(int usuario, int vehiculo, int sede){
        Cotizacion unaCotizacion= new Cotizacion();
        
        unaCotizacion.setId_usuario(usuario);
        unaCotizacion.setId_vehiculo(vehiculo);
        unaCotizacion.setId_sede(sede);
        
        int result = daoCotizacion.guardarCotizacion(unaCotizacion);
        return result;
    }
    public int consultarUltimaCotizacion(){
        int result = daoCotizacion.consultarCotizacionReciente();
        return result;
    }
    
    public ArrayList<Cotizacion> consultarCotizaciones(){
        ArrayList<Cotizacion> result = daoCotizacion.consultarCotizaciones();
        return result;
    }
    
 
}
