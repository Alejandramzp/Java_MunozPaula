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
    
    String usuario ="root";
    String contrasena ="Sena1234";
    String bd ="sistema_hospitalario";
    String ip ="localhost";
    String puerto ="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(cadena,usuario,contrasena); 
            JOptionPane.showMessageDialog(null,"La conexión se realizó con exito" );
        } catch (ClassNotFoundException | SQLException e) {  
            JOptionPane.showMessageDialog(null,"Error al conectarse a la BBDD, error:" + e.toString());
        }
        return con;
    }
}
