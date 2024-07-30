/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemahospitalario;

import java.util.Scanner;

/**
 *
 * @author camper
 */
public class SistemaHospitalario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HospitalCRUD hospital = new HospitalCRUD();
        
        // Scanner permite obtener la entrada de datos
        Scanner sn1 = new Scanner(System.in); 
        boolean salir1 = false;
        int opcion1; //Opcion del usuario
        
        while(!salir1){ // mientras salir sea true 
           
            System.out.println("------Menú-----");
            System.out.println("1. Ver Hospital");
            System.out.println("2. Crear Hospital");
            System.out.println("3. Actualizar Hospital");
            System.out.println("4. Eliminar Hospital");
            System.out.println("5. Salir");
            
            System.out.println("Escriba una de las opciones");
            opcion1 = sn1.nextInt(); //recibe el numero entero y lo compara 
            
            switch (opcion1){
                
                case 1 -> hospital.VerHospital();
                case 2 -> hospital.InsertarHospital();
                case 3 -> hospital.ActualizarHospital();
                case 4 -> hospital.DeleteHospital();
                case 5 -> {
                System.out.println("\n --- Saliendo --- \n");
                    salir1 = true;}
                default -> System.out.println("\n ---- Opción Incorrecta --- \n ");
            }
            }
    }
    
}
