/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Herencia;

/**
 *
 * @author Admin
 */
public class Hmain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estudiante estudiante1 = new Estudiante(
                "1000001",
                "Pepito Perez",
                "123456"
        );
        System.out.println(estudiante1.getNombre());
    }
    
}
