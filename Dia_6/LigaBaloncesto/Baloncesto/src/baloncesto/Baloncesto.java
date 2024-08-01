/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baloncesto;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Baloncesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean salir1 = false;
        int opcion1;
        
        while (salir1 == false){
            System.out.println("------Menú Liga de Baloncesto-----");
            System.out.println("1. Partido Amistoso");
            System.out.println("2. Partido liga");
            System.out.println("3. Partido PlayOffs");
            System.out.println("4. Salir"); 
            
            System.out.println("Ingrese el número de la opción que desea");
            opcion1 = sc.nextInt();
            
            switch(opcion1){
                case 1->{}
                case 2->{}
                case 3->{}
                case 4->{
                    System.out.println("------Saliendo-----");
                    salir1 = true;
                }
            
            }
        }
        
    }
    
}
