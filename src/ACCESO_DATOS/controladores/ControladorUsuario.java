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
    
    public int insertarUsuario(int cedula, int sede, String nombre, Date fecha, String direccion, char genero, String e_mail, int cargo, int salario, String telefono, String estado, String cuenta, String contrasena){
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
    
    public ArrayList<Usuario> consultarUsuarios(){
        ArrayList<Usuario> users = daoUsuario.consultarUsuarios();
        return users;
                
    }
    
    public Usuario consultarUsuario(int cedula){
        Usuario user = daoUsuario.ConsultarUsuario(cedula);
        return user;
                
    }
    
    public int cambiarNombre(int cedula, String nombre){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        
        int result = daoUsuario.updateNombre(usuario);
        
        return result;
    }
    
    public int cambiarDireccion(int cedula, String direccion){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setDireccion(direccion);
        
        int result = daoUsuario.updateDireccion(usuario);
        
        return result;
    }
    
    public int cambiarEmail(int cedula, String email){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setEmail(email);
        
        int result = daoUsuario.updateEmail(usuario);
        
        return result;
    }
    
    public int cambiarTelefono(int cedula, String telefono){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setTelefono(telefono);
        
        int result = daoUsuario.updateTelefono(usuario);
        
        return result;
    }
    
    public int cambiarSede(int cedula, int sede){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setSede(sede);
        
        int result = daoUsuario.updateSede(usuario);
        
        return result;
    }
    
    public int cambiarEstado(int cedula, String estado){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setEstado(estado);
        
        int result = daoUsuario.updateEstado(usuario);
        
        return result;
    }
    
    public int cambiarSalario(int cedula, int salario){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setSalario(salario);
        
        int result = daoUsuario.updateSalario(usuario);
        
        return result;
    }
    
    public int cambiarUsuANDpass(int cedula, String cuenta, String contrasena){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(cedula);
        usuario.setCuenta(cuenta);
        usuario.setContrasena(contrasena);
        
        int result = daoUsuario.updateUsuANDpass(usuario);
        
        return result;
   
    }
}
