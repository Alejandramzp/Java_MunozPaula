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
 * @author camper
 */


public class CamperCRUD { //Declarar la lista y el scanner 
    private List<Camper> campers;
    private Scanner scanner;
    
    public CamperCRUD(){ //Constructor de la lista y el scanner
        campers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void createCamper(){ // Creacion de los datos del camper
        
        System.out.print("\n Ingrese el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese los nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese la direccion: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el acudiente: ");
        String acudiente = scanner.nextLine();
        System.out.print("Ingrese el número de celular: ");
        String celular = scanner.nextLine();
        System.out.print("Ingrese el número fijo: ");
        String fijo = scanner.nextLine();
        System.out.print("Ingrese el estado (Aprobado o Reprobado): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese el riesgo (Bajo o Alto): ");
        String riesgo = scanner.nextLine();
        
        Camper camper = new Camper(id, nombres,apellidos,direccion,acudiente,celular,fijo,estado,riesgo);
        campers.add(camper);
        System.out.println("\nEl proceso de creación de camper fue exitoso.");
    
    }
   
    public void readCamper(){ // leer los datos del camper
        if(campers.isEmpty()){
            System.out.println("\n No hay campers registrados.");
        } else {
            for (Camper camper : campers){
            System.out.println(camper);
            }
        }
    }
   
    private Camper findCamperById(int id){ //Encontrar el camper por ID
        for (Camper camper : campers){
            if (camper.getId() == id){
                return camper;
            }
        }
        return null;
    }    
    
    public void updateCamper(){
        System.out.print("\n Ingrese el ID del camper a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Camper camper = findCamperById(id);
        
        if(camper == null){
            System.out.println("El camper no se encuentra.");
        } else {
            System.out.println("Nombre actual: "+"|"+ camper.getNombres() + "|");
            System.out.println("Ingrese nombres nuevos: ");
            String nombres = scanner.nextLine();
            camper.setNombres(nombres);
            
            System.out.println("Apellido actual: "+"|"+ camper.getApellidos() + "|");
            System.out.println("Ingrese apellidos nuevos: ");
            String apellidos = scanner.nextLine();
            camper.setApellidos(apellidos);
            
            System.out.println("Direccion actual: "+"|"+ camper.getDireccion() + "|");
            System.out.println("Ingrese direccion nueva: ");
            String direccion = scanner.nextLine();
            camper.setDireccion(direccion);
            
            System.out.println("Acudiente actual: "+"|"+ camper.getAcudiente() + "|");
            System.out.println("Ingrese acudiente nuevo: ");
            String acudiente = scanner.nextLine();
            camper.setAcudiente(acudiente);
            
            System.out.println("Número de celular actual: "+"|"+ camper.getCelular() + "|");
            System.out.println("Ingrese número de celular nuevo: ");
            String celular = scanner.nextLine();
            camper.setCelular(celular);
            
            System.out.println("Número fijo actual: "+"|"+ camper.getFijo() + "|");
            System.out.println("Ingrese número fijo nuevo: ");
            String fijo = scanner.nextLine();
            camper.setFijo(fijo);
            
            System.out.println("Estado actual: "+"|"+ camper.getEstado() + "|");
            System.out.println("Ingrese estado nuevo: ");
            String estado = scanner.nextLine();
            camper.setEstado(estado);
            
            System.out.println("Riesgo actual: "+"|"+ camper.getRiesgo() + "|");
            System.out.println("Ingrese riesgo nuevo: ");
            String riesgo = scanner.nextLine();
            camper.setRiesgo(riesgo);
            
            System.out.println("Camper actualizado con exito.");
        }
    }
    
    public void deleteCamper() {
        System.out.print("Ingrese el ID del camper a eliminar: ");
        int id = scanner.nextInt();
        Camper camper = findCamperById(id);

        if (camper == null) {
            System.out.println("El camper no se encuentra.");
        } else {
            campers.remove(camper);
            System.out.println("Camper eliminado exitosamente.");
        }
    }

}
