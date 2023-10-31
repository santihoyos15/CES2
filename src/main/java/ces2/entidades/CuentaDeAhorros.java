package ces2.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CuentaDeAhorros implements CuentaBancaria {
    private double tasa = 0.01;
    private int numeroCuenta;
    private double balance = 0;
    private boolean esExtranjero = false;
    private Stack<Transaccion> transacciones = new Stack<>();

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

        Transaccion transaccion = new Transaccion();
        transaccion.setTipo(TipoTransaccion.DEPOSITO.getIndex());
        transaccion.setMonto(cantidad);

        transacciones.push(transaccion);
    }

    @Override
    public boolean tieneGarantia(double cantidad) {
        return balance >= cantidad / 2;
    }

    @Override
    public void retirar(double cantidad) {
        if (balance == 0) return;

        balance = cantidad > balance ? 0 : balance - cantidad;

        Transaccion transaccion = new Transaccion();
        transaccion.setTipo(TipoTransaccion.RETIRO.getIndex());
        transaccion.setMonto(Math.min(cantidad, balance));

        transacciones.push(transaccion);
    }

    public void addInteres () {
        balance += (int) (balance*tasa);
    }

    @Override
    public List<Transaccion> getTransacciones() {
        if (transacciones.empty()) return new ArrayList<>();

        return new ArrayList<>(transacciones);
    }

    @Override
    public Transaccion getUltimaTransaccion() {
        if (transacciones.empty()) return null;

        return transacciones.peek();
    }

    @Override
    public void autorizarPrestamo(double cantidad) {
        this.depositar(cantidad);

        Transaccion transaccion = new Transaccion();
        transaccion.setTipo(TipoTransaccion.PRESTAMO.getIndex());
        transaccion.setMonto(cantidad);

        transacciones.push(transaccion);
    }

    public String toString() {
        return "Cuenta de ahorros " + numeroCuenta
                + ": balance = " + balance
                + ", es " + (esExtranjero ? "extranjero" : "Local");
    }

    @Override
    public int compareTo(CuentaBancaria o) {
        if (this.balance == o.getBalance()) {
              return this.numeroCuenta - o.getNumeroCuenta();
        }

        return (int) (this.balance - o.getBalance());
    }
}
