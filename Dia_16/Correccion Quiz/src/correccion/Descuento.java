
package correccion;

public enum Descuento {
    BASICO(0.11),
    PLATINO(0.15),
    DIAMANTE(0.18);

    private final double porcentaje;

    Descuento(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double aplicarDescuento(double monto) {
        return monto * (1 - porcentaje);
    }
}




