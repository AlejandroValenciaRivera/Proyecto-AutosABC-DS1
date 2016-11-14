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
public class ControladorUsuario {
    DAOUsuario daoUsuario;
    
    public ControladorUsuario(){
        daoUsuario = new DAOUsuario();
    }
    
    public int insertarUsuario(int cedula, Sede sede, String nombre, Date fecha, String direccion, char genero, String e_mail, int cargo, int salario, String telefono, String estado, String cuenta, String contrasena){
        Usuario usu = new Usuario();
        usu.setCedula(cedula);
        usu.setSede(sede);
        usu.setNombre(nombre);
        usu.setFecha(fecha);
        usu.setDireccion(direccion);
        usu.setGenero(genero);
        usu.setEmail(e_mail);
        usu.setCargo(cargo);
        usu.setSalario(salario);
        usu.setTelefono(telefono);
        usu.setEstado(estado);
        usu.setCuenta(cuenta);
        usu.setContrasena(contrasena);
        
        int result = daoUsuario.GuardarUsuario(usu);
        
        return result;
    }
    
    public ArrayList<Usuario> consultarLogin(){
        ArrayList<Usuario> users = daoUsuario.consultarLogin();
        return users;
                
    }
}
