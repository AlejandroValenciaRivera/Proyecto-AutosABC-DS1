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
    
    public int modificarEstado(int id_vehiculo, String estado){
        Vehiculo vehiculo = new Vehiculo();
        
        vehiculo.setVehiculo(id_vehiculo);
        vehiculo.setEstado(estado);
        
        int result = daoVehiculo.updateEstado(vehiculo);
        
        return result;
    }
    public int modificarSede(int id_vehiculo, int  sede){
        Vehiculo vehiculo = new Vehiculo();
        
        vehiculo.setVehiculo(id_vehiculo);
        vehiculo.setId_sede(sede);
        
        int result = daoVehiculo.updateSede_id(vehiculo);
        
        return result;
    }
    
    public int modificarPrecio(int id_vehiculo, int precio){
        Vehiculo vehiculo = new Vehiculo();
        
        vehiculo.setVehiculo(id_vehiculo);
        vehiculo.setPrecio(precio);
        
        int result = daoVehiculo.updatePrecio(vehiculo);
        
        return result;
    }
    
    public int modificarIva(int id_vehiculo, int iva){
        Vehiculo vehiculo = new Vehiculo();
        
        vehiculo.setVehiculo(id_vehiculo);
        vehiculo.setIva(iva);
        
        int result = daoVehiculo.updateIva(vehiculo);
        
        return result;
    }
}

