package ces2.entidades;

public interface CuentaBancaria extends Comparable<CuentaBancaria> {
    int getNumeroCuenta();
    double getBalance();
    boolean esExtranjero();
    void setExtranjero(boolean esExtranjero);
    void depositar(double cantidad);
    boolean tieneGarantia(double cantidad);
}
