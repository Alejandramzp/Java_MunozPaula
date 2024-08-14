
package Ejercicio1;

public class Heroe {
  
    private static Heroe instanciaUnica;

    private Heroe() {
        
    }

    public static Heroe getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Heroe();
        }
        return instanciaUnica;
    }

}