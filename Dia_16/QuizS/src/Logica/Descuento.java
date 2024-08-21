
package Logica;
    
 //3 Tipos de descuento:
 // Joven = 11%, Nomina = 15%, Visa 18%
 // DJoven = valorApertura - (valorApertura * 0.11)
 // DNomina = valorApertura - (valorApertura * 0.15)
 // DVisa = valorApertura - (valorApertura * 0.18)

public enum Descuento {
    BASICO(0.11),
    PLATINO(0.15),
    DIAMANTE(0.18);

    private double descuento;

    private Descuento(double descuento) {
        this.descuento = descuento;
    }

    public double getValorDescontado(double monto) {
        return this.descuento * monto;
    }
}