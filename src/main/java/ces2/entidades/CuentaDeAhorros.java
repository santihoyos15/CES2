package ces2.entidades;

public class CuentaDeAhorros implements CuentaBancaria{
    private double tasa = 0.01;
    private int numeroCuenta;
    private double balance = 0;
    private boolean esExtranjero = false;

    public CuentaDeAhorros(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public double getBalance() {
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
    public void depositar(double cantidad) {
        balance += cantidad;
    }

    @Override
    public boolean tieneGarantia(double cantidad) {
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

    @Override
    public int compareTo(CuentaBancaria o) {
        if (this.balance == o.getBalance()) {
              return this.numeroCuenta - o.getNumeroCuenta();
        }

        return (int) (this.balance - o.getBalance());
    }
}
