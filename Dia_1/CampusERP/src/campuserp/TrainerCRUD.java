/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campuserp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TrainerCRUD {
    private List<Trainer> trainers;
    private Scanner scanner;
    
    public TrainerCRUD(){ //Constructor de la lista y el scanner
        trainers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void createTrainer(){ // Creacion de los datos del trainer
        
        System.out.print("\n Ingrese el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese los nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el número de celular: ");
        String celular = scanner.nextLine();
        System.out.print("Ingrese el salón (Artemis, Apolo o Sputnik): ");
        String salon = scanner.nextLine();
        
        Trainer trainer = new Trainer(id, nombres,apellidos,celular,salon);
        trainers.add(trainer);
        System.out.println("\nEl proceso de creación de trainer fue exitoso.");
    
    }
   
    public void readTrainer(){ // leer los datos del trainer
        if(trainers.isEmpty()){
            System.out.println("\n No hay trainers registrados.");
        } else {
            for (Trainer trainer : trainers){
            System.out.println(trainer);
            }
        }
    }
   
    private Trainer findTrainerById(int id){ //Encontrar el trainer por ID
        for (Trainer trainer : trainers){
            if (trainer.getId() == id){
                return trainer;
            }
        }
        return null;
    }    
    
    public void updateTrainer(){
        System.out.print("\n Ingrese el ID del trainer a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Trainer trainer = findTrainerById(id);
        
        if(trainer == null){
            System.out.println("El trainer no se encuentra.");
        } else {
            System.out.println("Nombre actual: "+"|"+ trainer.getNombres() + "|");
            System.out.println("Ingrese nombres nuevos: ");
            String nombres = scanner.nextLine();
            trainer.setNombres(nombres);
            
            System.out.println("Apellido actual: "+"|"+ trainer.getApellidos() + "|");
            System.out.println("Ingrese apellidos nuevos: ");
            String apellidos = scanner.nextLine();
            trainer.setApellidos(apellidos);
                       
            System.out.println("Número de celular actual: "+"|"+ trainer.getCelular() + "|");
            System.out.println("Ingrese número de celular nuevo: ");
            String celular = scanner.nextLine();
            trainer.setCelular(celular);
                  
            System.out.println("Salon actual: "+"|"+ trainer.getSalon() + "|");
            System.out.println("Ingrese salon nuevo: ");
            String salon = scanner.nextLine();
            trainer.setSalon(salon);
            
            System.out.println("Trainer actualizado con exito.");
        }
    }
    
    public void deleteTrainer() {
        System.out.print("Ingrese el ID del trainer a eliminar: ");
        int id = scanner.nextInt();
        Trainer trainer = findTrainerById(id);

        if (trainer == null) {
            System.out.println("El trainer no se encuentra.");
        } else {
            trainers.remove(trainer);
            System.out.println("Trainer eliminado exitosamente.");
        }
    }

}
