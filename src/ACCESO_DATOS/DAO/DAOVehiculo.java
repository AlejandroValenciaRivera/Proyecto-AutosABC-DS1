/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.DAO;

import ACCESO_DATOS.conexion.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                + vehiculo.getVehiculo() + ", "
                + vehiculo.getId_sede() + ", '"
                + vehiculo.getColor() + "', '"
                + vehiculo.getMarca() + "', '"
                + vehiculo.getReferencia() + "', '"
                + vehiculo.getTipo() + "', '"
                + vehiculo.getTraccion() + "', '"
                + vehiculo.getModelo() + "', "
                + vehiculo.getPrecio() + ", "
                + vehiculo.getIva() + " )";
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(statement_save);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
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
                + "iva FROM vehiculos WHERE id_vehiculo = " + idVehiculo;

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

            fachada.closeConection();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        return unVehiculo;
    }

    /**
     * +++++++++++++++++++++++++++++++++PARTE DE UPDATE PARA
     * VEHICULOS++++++++++++++++++++++++++++++++++++++++++++++++++
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
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updateColor(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET color = '" + vehiculo.getColor() + "' WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;

    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updateMarca(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET marca = '" + vehiculo.getMarca() + "' WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updateReferencia(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET referencia = '" + vehiculo.getReferencia() + "' WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updateTipo(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET tipo = '" + vehiculo.getTipo() + "' WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updateTraccion(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET traccion = '" + vehiculo.getTraccion() + "' WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }

    /**
     *
     * @param vehiculo
     * @return int
     */
    public int updateModelo(Vehiculo vehiculo) {
        String update_statement = "UPDATE vehiculos SET modelo = '" + vehiculo.getModelo() + "' WHERE id_vehiculo = " + vehiculo.getVehiculo();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConection();
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
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
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
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
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
        return numFilas;
    }
    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++FIN PARTE UPDATE PARA VEHICULOS++++++++++++++++++++++++++++++++++++++++++*
     */
    /**
     * >:V *
     */
}
