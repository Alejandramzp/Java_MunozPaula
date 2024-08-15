
package carrera;


// Clase Atleta que representa un corredor en la carrera
public class Atleta extends Thread {
    private Testigo testigo;
    private int id;

    public Atleta(int id, Testigo testigo) {
        this.id = id;
        this.testigo = testigo;
    }

    @Override
    public void run() {
        try {
            if (id == 0) {
                // Primer atleta empieza sin esperar
                correr();
                testigo.pasarTestigo();
            } else {
                // Otros atletas deben esperar a que el testigo sea pasado
                testigo.recibirTestigo();
                correr();
                testigo.pasarTestigo();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void correr() throws InterruptedException {
        int tiempo = 9000 + (int) (Math.random() * 2000); // Entre 9000 y 11000 ms
        System.out.println("Atleta " + (id+1) + " corriendo. Tiempo estimado: " + tiempo + " ms");
        Thread.sleep(tiempo);
        System.out.println("Atleta " + (id+1) + " ha terminado.");
    }
}


