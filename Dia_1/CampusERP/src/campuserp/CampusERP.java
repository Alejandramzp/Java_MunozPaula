/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campuserp;

/**
 *
 * @author camper
 */
import java.util.Scanner;

public class CampusERP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CamperCRUD camperCRUD = new CamperCRUD();
        
        // Scanner permite obtener la entrada de datos
        Scanner sn1 = new Scanner(System.in); 
        boolean salir1 = false;
        int opcion1; //Opcion del usuario
        
        while(!salir1){ // mientras salir sea true 
           
            System.out.println("------Menú-----");
            System.out.println("1. Coordinador");
            System.out.println("2. Trainer");
            System.out.println("3. Camper");
            System.out.println("4. Salir");
            
            System.out.println("Escriba una de las opciones");
            opcion1 = sn1.nextInt(); //recibe el numero entero y lo compara 
            
            switch (opcion1){
                
                case 1 -> {
                        
                    Scanner sn2 = new Scanner(System.in); 
                    boolean salir2 = false;
                    int opcion2; //Opcion del usuario
        
                    while(!salir2){ // mientras salir sea true 
                        System.out.println("\n --- Menú Coordinador --- \n ");
                        System.out.println("1. Agregar camper");
                        System.out.println("2. Ver camper");
                        System.out.println("3. Actualizar camper");
                        System.out.println("4. Eliminar camper");
                        System.out.println("5. Salir");
                            
                        System.out.println("Escriba una de las opciones");
                        opcion2 = sn2.nextInt(); //recibe el numero entero y lo compara
                            
                        switch (opcion2){
                            case 1 -> camperCRUD.createCamper(); 
                            case 2 -> camperCRUD.readCamper();
                            case 3 -> camperCRUD.updateCamper();
                            case 4 -> camperCRUD.deleteCamper();
                            case 5 -> {
                                System.out.println("\n --- Saliendo --- \n");
                                salir2 = true;
                            }
                            default -> System.out.println("\n ---- Opción Incorrecta --- \n ");
                        }    
                    }     
                }
                case 2 -> System.out.println(" \n --- Entraste a Trainer --- \n");
                case 3 -> System.out.println("\n --- Entraste a Camper --- \n");
                case 4 -> { 
                    System.out.println("\n --- Saliendo --- \n");
                    salir1 = true;
                }
                default -> System.out.println("\n ---- Opción Incorrecta --- \n ");
            }
            
        }
          
    }
    
}
