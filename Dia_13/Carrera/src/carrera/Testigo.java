
package carrera;

// Clase Testigo para sincronizar el paso del testigo entre los atletas
public class Testigo {
    private boolean turno = true; // true significa que el primer atleta puede comenzar

    public synchronized void pasarTestigo() throws InterruptedException {
        while (!turno) {
            wait(); // Esperar hasta que sea el turno del atleta
        }
        turno = false; // Indicar que el turno pasa al siguiente atleta
        notifyAll(); // Notificar a otros hilos
    }

    public synchronized void recibirTestigo() throws InterruptedException {
        while (turno) {
            wait(); // Esperar hasta que sea el turno del atleta
        }
        turno = true; // Indicar que el turno pasa al primer atleta
        notifyAll(); // Notificar a otros hilos
    }
}