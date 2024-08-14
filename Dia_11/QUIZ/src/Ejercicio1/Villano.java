
package Ejercicio1;


import java.util.HashMap;
import java.util.Map;

public class Villano {
    private static final int MAX_INSTANCIAS = 5;
    private static Map<String, Integer> conteoInstancias = new HashMap<>();
    private String tipo;

    // Constructor privado
    private Villano(String tipo) {
        this.tipo = tipo;
    }

    // Método estático para crear o obtener una instancia de Villano
    public static Villano getInstancia(String tipo) {
        if (!conteoInstancias.containsKey(tipo)) {
            conteoInstancias.put(tipo, 0);
        }

        int conteo = conteoInstancias.get(tipo);

        if (conteo >= MAX_INSTANCIAS) {
            throw new IllegalStateException("Límite de instancias alcanzado para el tipo: " + tipo);
        }

        conteoInstancias.put(tipo, conteo + 1);
        return new Villano(tipo);
    }
    
}
