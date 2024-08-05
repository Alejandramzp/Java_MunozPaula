/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Conexion {
    
    Connection con = null;
    
    public Connection Conectar(){
        
        Properties props= new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("Config.properties")){
            if(input == null){
                throw new IllegalAccessException("Archivo Config.properties no encontrado");
            }
            
            props.load(input);
            
            String url = props.getProperty("DB_URL");
            String user = props.getProperty("DB_USER");
            String password = props.getProperty("DB_PASSWORD");
            
            if (url == null || user == null || password == null) {
                throw  new IllegalAccessException("Alguna de las propiedades de la conexión no está definida");
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
                    
        } catch (IOException | ClassNotFoundException | SQLException | IllegalAccessException e) {
            System.err.println("Error al conectarse a la BBDD, error:" + e);
            JOptionPane.showMessageDialog(null,"Error al conectarse a la BBDD, error:" + e.toString());
        }
        
        return con;
    }
}
