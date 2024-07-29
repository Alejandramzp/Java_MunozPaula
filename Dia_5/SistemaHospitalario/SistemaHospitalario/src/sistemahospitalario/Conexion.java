/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author camper
 */
public class Conexion {
    Connection con = null;
    
    String usuario = "uga2octczsrujwmj";
    String contrasena = "sS8sgEoDTCNSvBuMv9Rk";
    String bd = "bizpdarpe0g2ttcjyaok";
    String ip = "bizpdarpe0g2ttcjyaok-mysql.services.clever-cloud.com";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(cadena,usuario,contrasena); 
            JOptionPane.showMessageDialog(null,"La conexión se realizó con exito" );
            System.out.println("La conexión se realizó con exito" );
            
        } catch (ClassNotFoundException | SQLException e) {  
            System.err.println("Error al conectarse a la BBDD, error:" + e);
            JOptionPane.showMessageDialog(null,"Error al conectarse a la BBDD, error:" + e.toString());
            
        }
        return con;
    }
}
