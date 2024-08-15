
package carrera;

// Carrera 4 x 100
// Tenemos 4 atletas dispuestos a correr
// Tenemos una clase principal carrera
// Tenemos un obgeto estatico testigo
// Todos los atletas empiezan parados, uno comienza a correr (tarda entre 9 y 11 s) termina su carrera y inmediatamente comienza otro.

// Pistas:
// Thread.sleep y Math.random para la carrera
// synchronized,wait y notify para el paso de testigos
// System.currentTimeMillis o Calendar para ver tiempos

public class Carrera {

    public static void main(String[] args) {
        Testigo testigo = new Testigo();
        Atleta[] atletas = new Atleta[4];

        // Crear y empezar los hilos de los atletas
        for (int i = 0; i < 4; i++) {
            atletas[i] = new Atleta(i, testigo);
            atletas[i].start();
        }

        // Esperar a que todos los atletas terminen
        try {
            for (Atleta atleta : atletas) {
                atleta.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("La carrera ha terminado.");
    }
    
}
