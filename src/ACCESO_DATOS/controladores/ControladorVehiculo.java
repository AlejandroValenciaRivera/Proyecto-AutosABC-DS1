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
public class ControladorVehiculo {
    DAOVehiculo daoVehiculo;
    
    public ControladorVehiculo(){
        daoVehiculo = new DAOVehiculo();
    }
    
    public int insertarVehiculo(int sede, String color, String marca, String referencia, String modelo, String traccion, String tipo, int precio, int iva, String estado){
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
        vehiculo.setEstado(estado);
        
        int result = daoVehiculo.guardarVehiculo(vehiculo);
        
        return result;
    }
    
    public ArrayList<Vehiculo> consultarVehiculos(){
        ArrayList<Vehiculo> vehiculos = daoVehiculo.consultarVehiculos();
 
        return vehiculos;
    }
}

