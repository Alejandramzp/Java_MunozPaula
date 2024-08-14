
package Ejercicio1;


public class Prueba {
    public static void main(String[] args) {
        // Prueba del Singleton Heroe
        System.out.println("Prueba de Singleton Heroe");
        Heroe heroe1 = Heroe.getInstancia();
        Heroe heroe2 = Heroe.getInstancia();

        System.out.println("Heroe 1: " + heroe1);
        System.out.println("Heroe 2: " + heroe2);
        System.out.println("¿Son la misma instancia? " + (heroe1 == heroe2));
        
        // Prueba de la Factory Villano
        System.out.println("\nPrueba de Factory Villano");
        try {
            Villano villano1 = Villano.getInstancia("TipoA");
            Villano villano2 = Villano.getInstancia("TipoA");
            Villano villano3 = Villano.getInstancia("TipoA");
            Villano villano4 = Villano.getInstancia("TipoA");
            Villano villano5 = Villano.getInstancia("TipoA");
            Villano villano6 = Villano.getInstancia("TipoA"); // Debería lanzar excepción

            System.out.println("Villano 1: " + villano1);
            System.out.println("Villano 2: " + villano2);
            System.out.println("Villano 3: " + villano3);
            System.out.println("Villano 4: " + villano4);
            System.out.println("Villano 5: " + villano5);
            System.out.println("Villano 6: " + villano6);

        } catch (IllegalStateException e) {
            System.out.println("Excepción esperada: " + e.getMessage());
        }
    }
}