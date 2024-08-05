/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;
/**
 *
 * @author Admin
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Partido {
    protected String equipoLocal;
    protected String equipoVisitante;
    protected int cestasLocal;
    protected int cestasVisitante;
    protected boolean finalizado;
    protected String fecha;
    
    private Connection con;

    public Partido() {
    }

    public Partido(String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean finalizado, String fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.cestasLocal = cestasLocal;
        this.cestasVisitante = cestasVisitante;
        this.finalizado = finalizado;
        this.fecha = fecha;
    }

    public void puntosLocal(int puntos){}
    public void puntosVisitante(int puntos){}
    
    public void Ganador() {
        System.out.println("--.--.--.--.--.--.--.--.--.--");
        if (finalizado == true){
          if (cestasLocal > cestasVisitante) {
            System.out.println("El ganador del encuentro es: " + equipoLocal);
          } else if (cestasVisitante > cestasLocal) {
            System.out.println("El ganador del encuentro es: " + equipoVisitante);  
            }    
        }else{
            System.out.println("El partido no ha finalizado");
        }
        System.out.println("--.--.--.--.--.--.--.--.--.--");
    }
    
    public void FinalizarEncuentro(){
        System.out.println("--.--.--.--.--.--.--.--.--.--");
        if(finalizado == true){
            System.out.println("El partido ya se ha finalizado");
        }else{
            if(cestasLocal != cestasVisitante){
                System.out.println("El partido se ha finalizado exitosamente");
            }else{
                System.out.println("No es posible finalizar el partido hasta que haya un ganador");
            }
        }  
        System.out.println("--.--.--.--.--.--.--.--.--.--");
    }
    
    public void InfoPartido(){
        System.out.println("--.--.--.--.--.--.--.--.--.--");
        System.out.println("Fecha del partido: " + fecha);
        if(finalizado == true){
            System.out.println("-- El partido ya se terminó --");
        }else{
            System.out.println("El partido no ha terminado");
        }
        System.out.println("Equipo local: " + equipoLocal + " | Cestas: " + cestasLocal);
        System.out.println("Equipo Visitante: " + equipoVisitante + " | Cestas: " + cestasVisitante);
        System.out.println("--.--.--.--.--.--.--.--.--.--");
    }
    
    public void Resultados(){
        System.out.println("--.--.--.--.--.--.--.--.--.--");
        if(finalizado == true){
            System.out.println("Resultados: ");
            System.out.println("Equipo local: " + equipoLocal + "| Cestas: " + cestasLocal);
            System.out.println("Equipo Visitante: " + equipoVisitante + "| Cestas: " + cestasVisitante);
        }else{
            System.out.println("No disponible, el partido no ha terminado");
        }
        System.out.println("--.--.--.--.--.--.--.--.--.--");
    }
    
    public void InsertarPartido(){
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        con = cn.Conectar();
        
        try {
            ps = con.prepareStatement("INSERT INTO partido (equipo_local, equipo_visitante, cestas_local, cestas_visitante, finalizado, fecha) VALUES (?,?,?,?,?,?)");
            System.out.println("\n Ingrese el nombre del equipo local:");
            equipoLocal = sc.nextLine();
            
            System.out.println("\n Ingrese el nombre del equipo visitante:");
            equipoVisitante = sc.nextLine();
            
            System.out.println("\n Ingrese el número de cestas del equipo local:");
            cestasLocal = sc.nextInt();
            sc.nextLine();
            
            System.out.println("\n Ingrese el número de cestas del equipo visitante:");
            cestasVisitante = sc.nextInt();
            sc.nextLine();
            
            System.out.println("\n Ingrese 'TRUE' si el partido ha finalizado o 'FALSE' si no ha finalizado:");
            finalizado = sc.nextBoolean();
            sc.nextLine();
            
            System.out.println("\n Ingrese el año en que se realiza el partido:");
            String año = sc.nextLine();
            System.out.println("\n Ingrese el mes en que se realiza el partido:");
            String mes = sc.nextLine();
            System.out.println("\n Ingrese el día en que se realiza el partido:");
            String dia = sc.nextLine();
            
            fecha = año +"-"+ mes +"-"+ dia;
            
            ps.setString(1, equipoLocal);
            ps.setString(2, equipoVisitante);
            ps.setInt(3, cestasLocal);
            ps.setInt(4, cestasVisitante);
            ps.setBoolean(5, finalizado);
            ps.setString(6, fecha);
            ps.executeUpdate();
            
             System.out.println("\n Partido ingresado con exito \n");
            
        } catch (SQLException e) {
            System.err.println("\nError en la inserción:" + e);
        }finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("\nError cerrando Statement" + e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("\nError cerrando Conexion" + e);
                }
            }
        }
    }
     
    public String getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getCestasLocal() {
        return cestasLocal;
    }
    public void setCestasLocal(int cestasLocal) {
        this.cestasLocal = cestasLocal;
    }

    public int getCestasVisitante() {
        return cestasVisitante;
    }
    public void setCestasVisitante(int cestasVisitante) {
        this.cestasVisitante = cestasVisitante;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getFinalizado() {
        return finalizado;
    } 
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
}
