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
public class ControladorVehiculo {
    DAOVehiculo daoVehiculo;
    
    public ControladorVehiculo(){
        daoVehiculo = new DAOVehiculo();
    }
    
    public int insertarVehiculo(int sede, String color, String marca, String referencia, String modelo, String traccion, String tipo, int precio, int iva){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId_sede(sede);
        vehiculo.setColor(color);
        vehiculo.setMarca(marca);
        vehiculo.setReferencia(referencia);
        vehiculo.setModelo(modelo);
        vehiculo.setTraccion(traccion);
        vehiculo.setTipo(tipo);
        vehiculo.setPrecio(precio);
        vehiculo.setIva(iva);
        
        int result = daoVehiculo.guardarVehiculo(vehiculo);
        
        return result;
    }
}

