/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

/**
 *
 * @author Admin
 */
public class Playoffs extends Partido {
    private String ronda;

    public Playoffs(String ronda, String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean finalizado, String fecha) {
        super(equipoLocal, equipoVisitante, cestasLocal, cestasVisitante, finalizado, fecha);
        this.ronda = ronda;
    }

    public String getRonda() {
        return ronda;
    }
    public void setRonda(String ronda) {
        this.ronda = ronda;
    }
    
    public String obtenerGanador() {
        if (cestasLocal > cestasVisitante) {
            return equipoLocal;
        } else if (cestasVisitante > cestasLocal) {
            return equipoVisitante;
        } else {
            return "Empate";
        }
    }
  
    @Override
    public void puntosLocal(int puntos) {
        System.out.println("Puntos Local");
    }

    @Override
    public void puntosVisitante(int puntos) {
         System.out.println("Puntos Visitante");
    }
}
