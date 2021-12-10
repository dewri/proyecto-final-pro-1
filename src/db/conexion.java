/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author antho
 */
public class conexion {
    private String ruta="jdbc:sqlite:C:/Users/antho/Desktop/Tarea Prog #1/Tarea 4/lista_personas.s3db";
    Connection con = null;
    
    //Crea conexion
    public conexion(){
        
        try {
            Class.forName("org.sqlite.JDBC");
            con =DriverManager.getConnection(ruta);
            System.out.println("Conexion esxitosa");
        } catch (Exception e) {
            System.out.println("Error de conexion"+ e);

        }
    }
    //Verifica que los query se ejecuten correctamente
    public int provar_centencia(String centenciasql){
        try {
            PreparedStatement pstm = con.prepareStatement(centenciasql);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.print(e);
            return 0;
        }
   
    }
    // ejecuta las consultas 
    public ResultSet consulta(String centenciasql){
        try {
            PreparedStatement pstm = con.prepareStatement(centenciasql);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }       
    }
    //Crea una cexion especial para el login
    public static Connection conexion_login(){
        String ruta="jdbc:sqlite:C:/Users/antho/Desktop/Tarea Prog #1/Tarea 4/lista_personas.s3db";
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con =DriverManager.getConnection(ruta);
            System.out.println("Conexion esxitosa");
            
        } catch (Exception e) {
            System.out.println("Error de conexion"+ e);
            
        }return con;
    }
    
}
