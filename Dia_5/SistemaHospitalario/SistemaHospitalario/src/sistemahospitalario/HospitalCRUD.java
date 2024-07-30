/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class HospitalCRUD {
     private Connection con;

    public void VerHospital(){
        Conexion cn = new Conexion();
        Statement st = null;
        ResultSet rs = null;
        
        try {
            con = cn.Conectar();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM hospital");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")+ " " + "Nombre: " +
                        rs.getString( "H_nombre")+ " " + "Direccion: " +
                        rs.getString( "H_direccion"));   
            }
        } catch (SQLException e) {
            System.err.println("Error en la consulta:" + e);
        } finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando ResultSet" + e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Statement" + e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Conexion" + e);
                }
            }
        }
    }
   
    public void InsertarHospital(){
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        con = cn.Conectar();
        String Hnombre;
        String Hdireccion;
        try {
            ps = con.prepareStatement("INSERT INTO hospital (H_nombre,H_direccion) VALUES (?,?)");
            System.out.println("Ingresar el nombre del hospital: ");
            Hnombre = sc.nextLine();
            
            System.out.println("Ingresar la dirección del hospital: ");
            Hdireccion = sc.nextLine();
            
            ps.setString(1, Hnombre);
            ps.setString(2, Hdireccion);
            ps.executeUpdate();
            System.out.println("Hospital ingresado con exito");
        } catch (SQLException e) {
            System.err.println("Error en la inserción:" + e);
        } finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Statement" + e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Conexion" + e);
                }
            }
        }
    }
    
    public void ActualizarHospital(){
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        con = cn.Conectar();
        String Hnombre;
        String Hdireccion;
        int id_hospital;
    
        try {
            System.out.println("Ingresar el ID del hospital a actualizar: ");
            id_hospital = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Ingresar el nuevo nombre del hospital: ");
            Hnombre = sc.nextLine();
            
            System.out.println("Ingresar la nueva dirección del hospital: ");
            Hdireccion = sc.nextLine();
            
            ps = con.prepareStatement("UPDATE hospital SET hospital.H_nombre = ?, "
                    + "hospital.H_direccion = ? WHERE hospital.id = ?");
            ps.setString(1, Hnombre);
            ps.setString(2, Hdireccion);
            ps.setInt(3, id_hospital);
            
            int rowsUpdated = ps.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("Hospital Actualizado con exito");
            } else {
                System.out.println("No se encontró el ID del Hospital");
            }
        } catch (SQLException e) {
            System.err.println("Error en la Actualización:" + e);
        } finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Statement" + e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Conexion" + e);
                }
            }
        }
    }
    
    public void DeleteHospital(){
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        con = cn.Conectar();
        int id_hospital;
        try {
            ps = con.prepareStatement("DELETE FROM hospital WHERE hospital.id = ?");
            System.out.println("Ingresar el ID del hospital a eliminar: ");
            id_hospital = sc.nextInt();
            
            ps.setInt(1, id_hospital);
            ps.executeUpdate();
            
            System.out.println("Hospital eliminado con exito");
        } catch (SQLException e) {
            System.err.println("Error en la eliminación:" + e);
        }finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Statement" + e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando Conexion" + e);
                }
            }
        }
    }
    
}
