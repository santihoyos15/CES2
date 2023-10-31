package ces2.entidades;

import java.util.List;

public interface CuentaBancaria extends Comparable<CuentaBancaria> {
    int getNumeroCuenta();
    double getBalance();
    boolean esExtranjero();
    void setExtranjero(boolean esExtranjero);
    void depositar(double cantidad);
    boolean tieneGarantia(double cantidad);
    // Punto 2
    void retirar(double cantidad);
    // Punto 3
    List<Transaccion> getTransacciones();
    // Punto 3
    Transaccion getUltimaTransaccion();
    // Punto 3
    void autorizarPrestamo(double cantidad);
    // Punto 4
    String toString();
}
