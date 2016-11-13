/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_DATOS.conexion;

import java.sql.*;
/**
 *
 * @author aleja_000
 */
public class FachadaBD {
    String url, usuario, password;
    Connection conexion =null;
    Statement instruccion;
    ResultSet tabla;
    
    public FachadaBD(){
        url = "jdbc:postgresql://localhost:5432/AutosABC";
        usuario = "postgres";
        password = "123456789";
    }
        
        

    public Connection conectar(){
            try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            //System.out.println( "Driver Cargado" );
            } catch( Exception e ) {
                System.out.println( "No se pudo cargar el driver." );
            }

            try{
                     //Crear el objeto de conexion a la base de datos
                     conexion = DriverManager.getConnection(url, usuario, password);
                     System.out.println( "Conexion Abierta" );
                     return conexion;
                  //Crear objeto Statement para realizar queries a la base de datos
             } catch( Exception e ) {
                System.out.println( "No se pudo abrir la bd." );
                return null;
             }

    }//end connectar

    public Connection getConnetion(){
            if (conexion == null) {
                return this.conectar();
            }
            else{
                  return conexion;      
            }
            
    }
        
    public void closeConection(){
            try{
                if (conexion != null){
                    conexion.close();
                }
                 
            } catch( Exception e ) {
                System.out.println( "No se pudo cerrar." );
            }
    }
}
