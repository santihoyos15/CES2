package ces2.entidades;

public interface CuentaBancaria {
    int getNumeroCuenta();
    int getBalance();
    boolean esExtranjero();
    void setExtranjero(boolean esExtranjero);
    void depositar(int cantidad);
    boolean tieneGarantia(int cantidad);
}
