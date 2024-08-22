
package correccion;

public class Nomina extends Tarjeta {

    public Nomina(String numeroDeCuenta, double valorApertura, String mes) {
        super(numeroDeCuenta, valorApertura, mes);
    }

    @Override
    public double cuotaDeManejo() {

        double descuentoAplicado = Descuento.PLATINO.aplicarDescuento(getValorApertura());
        return descuentoAplicado;
    }
}
