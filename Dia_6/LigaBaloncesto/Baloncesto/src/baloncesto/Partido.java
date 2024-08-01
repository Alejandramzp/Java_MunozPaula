/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

/**
 *
 * @author Admin
 */
public abstract class Partido {
    
    protected String equipoLocal;
    protected String equipoVisitante;
    protected int cestasLocal;
    protected int cestasVisitante;
    protected boolean finalizado;
    protected String fecha;

    public Partido() {
    }

    public Partido(String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean finalizado, String fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.cestasLocal = cestasLocal;
        this.cestasVisitante = cestasVisitante;
        this.finalizado = finalizado;
        this.fecha = fecha;
    }

    public abstract void puntosLocal(int puntos);
    public abstract void puntosVisitante(int puntos);
     
    // public abstract String Ganador();
    
    public String getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getCestasLocal() {
        return cestasLocal;
    }
    public void setCestasLocal(int cestasLocal) {
        this.cestasLocal = cestasLocal;
    }

    public int getCestasVisitante() {
        return cestasVisitante;
    }
    public void setCestasVisitante(int cestasVisitante) {
        this.cestasVisitante = cestasVisitante;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getFinalizado() {
        return finalizado;
    } 
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
  
}
