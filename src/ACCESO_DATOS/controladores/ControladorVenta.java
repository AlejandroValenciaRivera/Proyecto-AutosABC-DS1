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
public class ControladorVenta {
    DAOVenta daoVenta;
    
    public ControladorVenta(){
        daoVenta = new DAOVenta();
    }
    
    public int insertarVenta(int vehiculo, int usuario, int sede, String pago, String cedula, String nombre, String telefono){
        Venta venta = new Venta();
        
        venta.setId_vehiculo(vehiculo);
        venta.setId_usuario(usuario);
        venta.setId_sede(sede);
        venta.setForma_pago(pago);
        venta.setCedula_cliente(cedula);
        venta.setNombre_cliente(nombre);
        venta.setTelefono_cliente(telefono);
        
        int result = daoVenta.guardarVenta(venta);
        return result;
    }
    
    public int consultarUltimaVenta(){
        int result = daoVenta.consultarVentaReciente();
        return result;
    }
}
