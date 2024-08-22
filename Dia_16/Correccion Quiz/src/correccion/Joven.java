
package correccion;

public class Joven extends Tarjeta {

    public Joven(String numeroDeCuenta, double valorApertura, String mes) {
        super(numeroDeCuenta, valorApertura, mes);
    }

    @Override
    public double cuotaDeManejo() {
        double descuentoAplicado = Descuento.BASICO.aplicarDescuento(getValorApertura());
        return descuentoAplicado;
    }
}
