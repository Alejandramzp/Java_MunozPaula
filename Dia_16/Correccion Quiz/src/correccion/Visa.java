
package correccion;

public class Visa extends Tarjeta {

    public Visa(String numeroDeCuenta, double valorApertura, String mes) {
        super(numeroDeCuenta, valorApertura, mes);
    }

    @Override
    public double cuotaDeManejo() {
        double descuentoAplicado = Descuento.DIAMANTE.aplicarDescuento(getValorApertura());
        return descuentoAplicado;
    }
}

