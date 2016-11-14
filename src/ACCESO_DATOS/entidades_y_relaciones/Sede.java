/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.entidades_y_relaciones;

/**
 *
 * @author aleja_000
 */
public class Sede {
    int id_sede;
    String nombre;
    String ciudad;
    String direccion;
    String telefono;
    String fax;
    
    public Sede(){
    
    }
    
    public int getId(){
        return id_sede;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCiudad(){
        return ciudad;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getFax(){
        return fax;
    }
    public void setId(int id_sede){
        this.id_sede = id_sede;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public void setFax(String fax){
        this.fax = fax;
    }  
}
