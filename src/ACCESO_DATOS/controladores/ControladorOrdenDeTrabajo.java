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
public class ControladorOrdenDeTrabajo {
    DAOOrdenDeTrabajo daoOrden;
    
    public ControladorOrdenDeTrabajo(){
        daoOrden = new DAOOrdenDeTrabajo();
    } 
    
    public int insertarOrden(int orden, int usuario, int repuesto, int vehiculo, int sede, int cantidad, String descripcion){
        OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo();
        
        ordenDeTrabajo.setId_orden(orden);
        ordenDeTrabajo.setId_usuario(usuario);
        ordenDeTrabajo.setId_repuesto(repuesto);
        ordenDeTrabajo.setId_vehiculo(vehiculo);
        ordenDeTrabajo.setId_sede(sede);
        ordenDeTrabajo.setCantidadRepuesto(cantidad);
        ordenDeTrabajo.setDescripcion(descripcion);
        
        int result = daoOrden.guardarOrdenDeTrabajo(ordenDeTrabajo);
        
        return result;
    }
    
    public ArrayList<OrdenDeTrabajo> consultarOrdenes() {
        ArrayList<OrdenDeTrabajo> ordenes = daoOrden.consultarTodas();
        return ordenes;
    }
}
