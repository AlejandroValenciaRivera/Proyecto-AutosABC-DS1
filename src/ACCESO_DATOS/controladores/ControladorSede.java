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
import javax.swing.JOptionPane;
/**
 *
 * @author aleja_000
 */
public class ControladorSede {
    DAOSede daoSede;
    
    public ControladorSede() {
        daoSede = new DAOSede();
    }
    
    public int insertarSede(int id_sede, String nombre, String ciudad, String direccion, String telefono, String fax){
        Sede sede = new Sede();
        
        sede.setId(id_sede);
        sede.setNombre(nombre);
        sede.setCiudad(ciudad);
        sede.setDireccion(direccion);
        sede.setTelefono(telefono);
        sede.setFax(fax);
        
        int result = daoSede.guardarSede(sede);
        return result;
    }
    
    public ArrayList<Sede> consultarSedes(){

        ArrayList<Sede> sedes = daoSede.consultarSedes();

        return sedes;
    }
    
    public int cambiarNombre(int id_sede, String nombre) {
        Sede sede = new Sede();
        
        sede.setId(id_sede);
        sede.setNombre(nombre);
        
        int result = daoSede.updateNombre(sede);
        
        return result;
    }
    
    public int cambiarCiudad(int id_sede, String ciudad) {
        Sede sede = new Sede();
        
        sede.setId(id_sede);
        sede.setCiudad(ciudad);
        
        int result = daoSede.updateCiudad(sede);
        
        return result;
    }
    
    public int cambiarDireccion(int id_sede, String direccion) {
        Sede sede = new Sede();
        
        sede.setId(id_sede);
        sede.setDireccion(direccion);
        
        int result = daoSede.updateDireccion(sede);
        
        return result;
    }
    
    public int cambiarTelefono(int id_sede, String telefono) {
        Sede sede = new Sede();
        
        sede.setId(id_sede);
        sede.setTelefono(telefono);
        
        int result = daoSede.updateTelefono(sede);
        
        return result;
    }
    public int cambiarFax(int id_sede, String fax) {
        Sede sede = new Sede();
        
        sede.setId(id_sede);
        sede.setFax(fax);
        
        int result = daoSede.updateFax(sede);
        
        return result;
    }
    
            
}
