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
public class ControladorRepuesto {
    DAORepuesto daoRepuesto;
    
    public ControladorRepuesto(){
        daoRepuesto = new DAORepuesto();
    }
    
    public int insertarRepuesto(int sede, String nombre, int cantidad, int precio, int iva, String descripcion){
        Repuesto repuesto = new Repuesto();
        repuesto.setId_sede(sede);
        repuesto.setNombre(nombre);
        repuesto.setCantidad(cantidad);
        repuesto.setPrecio_unidad(precio);
        repuesto.setIva(iva);
        repuesto.setDescripcion(descripcion);
        
        int result = daoRepuesto.guardarRepuesto(repuesto);
        
        return result;
    }
    
    public Repuesto consultarRepuesto(int sede, String nombre, int cantidad, int precio, int iva, String descripcion){
        Repuesto repuesto = new Repuesto();
        
        repuesto.setId_sede(sede);
        repuesto.setNombre(nombre);
        repuesto.setCantidad(cantidad);
        repuesto.setPrecio_unidad(precio);
        repuesto.setIva(iva);
        repuesto.setDescripcion(descripcion);
        
        Repuesto repuesto2 = daoRepuesto.consultarRepuesto2(repuesto);
        
        return repuesto2;
    }
    
    public int cambiarSede(int id_repuesto, int sede){
        Repuesto repuesto = new Repuesto();
        
        repuesto.setId_repuesto(id_repuesto);
        repuesto.setId_sede(sede);
        
        int result = daoRepuesto.updateId_sede(repuesto);
        
        return result;
    }
    
    public int cambiarNombre(int id_repuesto, String nombre){
        Repuesto repuesto = new Repuesto();
        
        repuesto.setId_repuesto(id_repuesto);
        repuesto.setNombre(nombre);
        
        int result = daoRepuesto.updateNombre(repuesto);
        
        return result;
    }
    
    public int cambiarCantidad(int id_repuesto, int cantidad){
        Repuesto repuesto = new Repuesto();
        
        repuesto.setId_repuesto(id_repuesto);
        repuesto.setCantidad(cantidad);
        
        int result = daoRepuesto.updateCantidad(repuesto);
        
        return result;
    }
    public int cambiarPrecio(int id_repuesto, int precio){
        Repuesto repuesto = new Repuesto();
       
        repuesto.setId_repuesto(id_repuesto);
        repuesto.setPrecio_unidad(precio);
        
        int result = daoRepuesto.updatePrecio_unidad(repuesto);
        
        return result;
    }
    
    public int cambiarIva(int id_repuesto, int iva){
        Repuesto repuesto = new Repuesto();
        
        repuesto.setId_repuesto(id_repuesto);
        repuesto.setIva(iva);
        
        int result = daoRepuesto.updateIva(repuesto);
        
        return result;
    }
    
}
