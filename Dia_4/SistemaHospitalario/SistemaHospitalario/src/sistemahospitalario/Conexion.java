/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author camper
 */
public class Conexion {
    Connection con;
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_hospitalario","campus2023","campus2023"); 
        } catch (Exception e) {  
            System.err.println("Error en la conexión:" + e);
        }
        return con;
    }
}
