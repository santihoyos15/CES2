package ces2.entidades;

public class CuentaCorriente implements CuentaBancaria {

    private int numeroCuenta;
    private int balance = 0;
    private boolean esExtranjero = false;

    public CuentaCorriente(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public int getNumeroCuenta() {
       return numeroCuenta;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean esExtranjero() {
        return esExtranjero;
    }

    @Override
    public void setExtranjero(boolean esExtranjero) {
        this.esExtranjero = esExtranjero;
    }

    @Override
    public void depositar(int cantidad) {
        balance += cantidad;
    }

    @Override
    public boolean tieneGarantia(int cantidad) {
        return balance >= 2 * cantidad / 2;
    }

    public String toString() {
        return "Cuenta de corriente " + numeroCuenta
                + ": balance = " + balance
                + ", es " + (esExtranjero ? "extranjero" : "Local");
    }
}