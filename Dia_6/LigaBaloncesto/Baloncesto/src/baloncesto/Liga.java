/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

/**
 *
 * @author Admin
 */
public class Liga extends Partido {
    private int jornada;

    public Liga(int jornada, String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean finalizado, String fecha) {
        super(equipoLocal, equipoVisitante, cestasLocal, cestasVisitante, finalizado, fecha);
        this.jornada = jornada;
    }

    public int getJornada() {
        return jornada;
    }
    public void setJornada(int jornada) {
        this.jornada = jornada;
    }
    
    @Override
    public void puntosLocal(int puntos) {
        this.cestasLocal = puntos;         
    }

    @Override
    public void puntosVisitante(int puntos) {
        this.cestasVisitante = puntos;
    }

}
