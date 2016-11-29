/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.entidades_y_relaciones;

import java.sql.*;
/**
 *
 * @author aleja_000
 */
public class Usuario {
    int cedula;
    int id_sede;
    String nombre;
    Date fecha_nacimiento;
    String direccion;
    char genero;
    String e_mail;
    int cargo;
    int salario;
    String telefono;
    String estado;
    String cuenta;
    String contrasena;
    
    public Usuario(){
        
    }
    
    public int getCedula() {
        return cedula;
    }
    public int getSede() {
        return id_sede;
    }
    public String getNombre() {
        return nombre;
    }
    public Date getFecha() {
        return fecha_nacimiento;
    }
    public String getDireccion() {
        return direccion;
    }
    public char getGenero() {
        return genero;
    }
    public String getEmail() {
        return e_mail;
    }
    public int getCargo() {
        return cargo;
    }
    public int getSalario() {
        return salario;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEstado() {
        return estado;
    }
    public String getCuenta() {
        return cuenta;
    }
    public String getContrasena() {
        return contrasena;
    }  
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public void setSede(int sede) {
        id_sede = sede;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecha(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    public void setEmail(String e_mail) {
        this.e_mail = e_mail;
    }
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
