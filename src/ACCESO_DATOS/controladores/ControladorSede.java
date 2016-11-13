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
}
