/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.DAO;

import ACCESO_DATOS.conexion.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja_000
 */
public class DAOVehiculo {

    FachadaBD fachada;

    public DAOVehiculo() {
        fachada = new FachadaBD();
    }

    /**
     * @param @param vehiculo
     * @return int
     * @proposito Recibir un objeto vehiculo para registrarlo en la base de
     * datos
     * @author Erik López P.
     */
    public int guardarVehiculo(Vehiculo vehiculo) {
        String statement_save = "INSERT INTO vehiculos VALUES ( "
                + "nextval('secuencia_id_vehiculo')" + ", "
                + vehiculo.getId_sede() + ", '"
                + vehiculo.getColor() + "', '"
                + vehiculo.getMarca() + "', '"
                + vehiculo.getReferencia() + "', '"
                + vehiculo.getTipo() + "', '"
                + vehiculo.getTraccion() + "', '"
                + vehiculo.getModelo() + "', "
                + vehiculo.getPrecio() + ", "
                + vehiculo.getIva() + ", '" 
                + vehiculo.getEstado() + "' )";
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(statement_save);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
    }

    /**
     *
     * @param idVehiculo
     * @return Vehiculo
     * @author Erik L+opez P.
     * @proposito buscar un vehiculo en la base de datos y lo retorna
     */
    public Vehiculo consultarVehiculo(int idVehiculo) {
        Vehiculo unVehiculo = new Vehiculo();
        String sql_select = "SELECT id, "
                + "id_sede,  "
                + "color, "
                + "marca, "
                + "referencia, "
                + "tipo, "
                + "traccion, "
                + "modelo, "
                + "precio, "
                + "iva, estado FROM vehiculos WHERE id_vehiculo = " + idVehiculo;

        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            unVehiculo.setVehiculo(tabla.getInt(1));
            unVehiculo.setId_sede(tabla.getInt(2));
            unVehiculo.setColor(tabla.getString(3));
            unVehiculo.setMarca(tabla.getString(4));
            unVehiculo.setReferencia(tabla.getString(5));
            unVehiculo.setTipo(tabla.getString(6));
            unVehiculo.setTraccion(tabla.getString(7));
            unVehiculo.setModelo(tabla.getString(8));
            unVehiculo.setPrecio(tabla.getInt(9));
            unVehiculo.setIva(tabla.getInt(10));
            unVehiculo.setEstado(tabla.getString(11));

            fachada.closeConection();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        return unVehiculo;
    }
    
    
    public ArrayList<Vehiculo> consultarVehiculos() {
        Vehiculo unVehiculo = new Vehiculo();
        String sql_select = "SELECT id_vehiculo, "
                + "id_sede,  "
                + "color, "
                + "marca, "
                + "referencia, "
                + "tipo, "
                + "traccion, "
                + "modelo, "
                + "precio, "
                + "iva, estado FROM vehiculos WHERE estado = 'DISPONIBLE'";
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unVehiculo = new Vehiculo();
                unVehiculo.setVehiculo(tabla.getInt(1));
                unVehiculo.setId_sede(tabla.getInt(2));
                unVehiculo.setColor(tabla.getString(3));
                unVehiculo.setMarca(tabla.getString(4));
                unVehiculo.setReferencia(tabla.getString(5));
                unVehiculo.setTipo(tabla.getString(6));
                unVehiculo.setTraccion(tabla.getString(7));
                unVehiculo.setModelo(tabla.getString(8));
                unVehiculo.setPrecio(tabla.getInt(9));
                unVehiculo.setIva(tabla.getInt(10));
                unVehiculo.setEstado(tabla.getString(11));
                
                vehiculos.add(unVehiculo);
            
            }
            

            fachada.closeConection();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        return vehiculos;
    }
    
    public ArrayList<Vehiculo> consultarVehiculos2() {
        Vehiculo unVehiculo = new Vehiculo();
        String sql_select = "SELECT id_vehiculo, "
                + "id_sede,  "
                + "color, "
                + "marca, "
                + "referencia, "
                + "tipo, "
                + "traccion, "
                + "modelo, "
                + "precio, "
                + "iva, estado FROM vehiculos";
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unVehiculo = new Vehiculo();
                unVehiculo.setVehiculo(tabla.getInt(1));
                unVehiculo.setId_sede(tabla.getInt(2));
                unVehiculo.setColor(tabla.getString(3));
                unVehiculo.setMarca(tabla.getString(4));
                unVehiculo.setReferencia(tabla.getString(5));
                unVehiculo.setTipo(tabla.getString(6));
                unVehiculo.setTraccion(tabla.getString(7));
                unVehiculo.setModelo(tabla.getString(8));
                unVehiculo.setPrecio(tabla.getInt(9));
                unVehiculo.setIva(tabla.getInt(10));
                unVehiculo.setEstado(tabla.getString(11));
                
                vehiculos.add(unVehiculo);
            
            }
            

            fachada.closeConection();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        return vehiculos;
    }
    
    /**
     * +++++++++++++++++++++++++++++++++PARTE DE UPDATE PARA VEHICULOS++++++++++++++++++++++++++++++++++++++++++++++++++
     *
     * @param vehiculo
     * @return int
     * @author Erik Lopez Pacheco
     * @proposito Los siguientes metodos Se les pasa un Vehicuo como parametro y
     * actualiza en la base sus atributos
     */
    public int updateSede_id(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET id_sede = " + vehiculo.getId_sede() + " WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updatePrecio(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET precio = " + vehiculo.getPrecio() + " WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updateIva(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET iva = " + vehiculo.getIva() + " WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }
    
    public int updateEstado(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET estado = '" + vehiculo.getEstado() + "' WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        
    }
    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++FIN PARTE UPDATE PARA VEHICULOS++++++++++++++++++++++++++++++++++++++++++*
     */
    /**
     * >:V *
     */
}
