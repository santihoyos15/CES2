package ces2.entidades;

public class CuentaDeAhorros implements CuentaBancaria{
    private double tasa = 0.01;
    private int numeroCuenta;
    private int balance = 0;
    private boolean esExtranjero = false;

    public CuentaDeAhorros(int numeroCuenta) {
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
        return balance >= cantidad / 2;
    }

    public String toString() {
        return "Cuenta de ahorros " + numeroCuenta
                + ": balance = " + balance
                + ", es " + (esExtranjero ? "extranjero" : "Local");
    }

    public void addInteres () {
        balance += (int) (balance*tasa);
    }
}
