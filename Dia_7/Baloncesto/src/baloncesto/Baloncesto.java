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
        
        Partido partido1 = new Partido();
        
        //Partido partido1 = new Partido("Los Angeles Lakers","Chicago Bulls",30,15,true,"2024-06-17");
        Liga liga1 = new Liga(2,"Boston Celtics","Miami Heat",20,25,true,"2024-05-22");
        Playoffs playoffs1 = new Playoffs("Cuartos","Minnesota Timberwolves","Charlotte Hornets",15,15,false,"2024-07-10");
        
        while (salir1 == false){
            System.out.println("------Menú Liga de Baloncesto-----");
            System.out.println("1. Insertar Partido");
            System.out.println("2. Partido Amistoso");
            System.out.println("3. Partido liga");
            System.out.println("4. Partido PlayOffs");
            System.out.println("5. Salir"); 
            
            System.out.println("Ingrese el número de la opción que desea");
            opcion1 = sc.nextInt();
            
            switch(opcion1){
                case 1 ->{partido1.InsertarPartido();}
                case 2->{
                    boolean salir2 = false;
                    int opcion2;
        
                    while (salir2 == false){
                        System.out.println("------Partido Amistoso -----");
                        System.out.println("1. Información del partido");
                        System.out.println("2. Resultados del partido");
                        System.out.println("3. Equipo Ganador");
                        System.out.println("4. Finalizar Partido"); 
                        System.out.println("5. Salir");
            
                        System.out.println("Ingrese el número de la opción que desea");
                        opcion2 = sc.nextInt();
            
                        switch(opcion2){
                            case 1->{partido1.InfoPartido();}
                            case 2->{partido1.Resultados();}
                            case 3->{partido1.Ganador();}
                            case 4->{partido1.FinalizarEncuentro();}
                            case 5->{
                            System.out.println("------Saliendo-----");
                            salir2 = true;
                            }
                        }
                    }   
                }
                
                case 3->{
                    boolean salir2 = false;
                    int opcion2;
        
                    while (salir2 == false){
                        System.out.println("------Partido liga -----");
                        System.out.println("1. Información del partido");
                        System.out.println("2. Resultados del partido");
                        System.out.println("3. Equipo Ganador");
                        System.out.println("4. Finalizar Partido"); 
                        System.out.println("5. Salir"); 
            
                        System.out.println("Ingrese el número de la opción que desea");
                        opcion2 = sc.nextInt();
            
                        switch(opcion2){
                            case 1->{
                                System.out.println("Jornada: "+ liga1.getJornada());
                                liga1.InfoPartido();
                            }
                            case 2->{liga1.Resultados();}
                            case 3->{liga1.Ganador();}
                            case 4->{liga1.FinalizarEncuentro();}
                            case 5->{
                            System.out.println("------Saliendo-----");
                            salir2 = true;
                            }
                        }
                    }              
                }
                
                case 4->{
                    boolean salir2 = false;
                    int opcion2;
        
                    while (salir2 == false){
                        System.out.println("------Partido PlayOffs -----");
                        System.out.println("1. Información del partido");
                        System.out.println("2. Resultados del partido");
                        System.out.println("3. Equipo Ganador");
                        System.out.println("4. Finalizar Partido"); 
                        System.out.println("5. Salir"); 
            
                        System.out.println("Ingrese el número de la opción que desea");
                        opcion2 = sc.nextInt();
                        switch(opcion2){
                            case 1->{
                                System.out.println("Ronda: "+ playoffs1.getRonda());
                                playoffs1.InfoPartido();
                            }
                            case 2->{playoffs1.Resultados();}
                            case 3->{playoffs1.Ganador();}
                            case 4->{playoffs1.FinalizarEncuentro();}
                            case 5->{
                            System.out.println("------Saliendo-----");
                            salir2 = true;
                            }
                        }
                    }   
                }
                
                case 5->{
                    System.out.println("------Saliendo-----");
                    salir1 = true;
                }
            
            }
        }
        
    }
    
}
