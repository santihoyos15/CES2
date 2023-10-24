package ces2.entidades;

import java.util.HashMap;

public class Banco {
    private HashMap<Integer, CuentaBancaria> cuentas;
    private int siguienteCuenta;

    public Banco () {
        this.cuentas = new HashMap<>();
        this.siguienteCuenta = 1000;
    }

    public int nuevaCuenta(int tipo, boolean esExtranjero) {
        int numeroCuenta = this.siguienteCuenta++;
        CuentaBancaria cuentaBancaria;

        if (tipo == 1) {
            cuentaBancaria = new CuentaDeAhorros(numeroCuenta);
        } else {
            cuentaBancaria = new CuentaCorriente(numeroCuenta);
        }

        cuentaBancaria.setExtranjero(esExtranjero);

        this.cuentas.put(cuentaBancaria.getNumeroCuenta(), cuentaBancaria);

        return cuentaBancaria.getNumeroCuenta();
    }

    public int getBalance (int numeroCuenta) {
        return cuentas.get(numeroCuenta).getBalance();
    }

    public void depositar (int cantidad, int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);
        cuenta.depositar(cantidad);
    }

    public boolean autorizarPrestamo (int cantidad, int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);
        if (!cuenta.tieneGarantia(cantidad)) {
            return false;
        }

        cuenta.depositar(cantidad);
        return true;
    }

    public void addInteres (int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);

        if (!(cuenta instanceof CuentaDeAhorros)) {
            return;
        }

        CuentaDeAhorros cuentaAhorros = (CuentaDeAhorros) cuenta;
        cuentaAhorros.addInteres();
    }

    public HashMap<Integer, CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void cambiarNacionalidad(boolean esExtranjero, int numeroCuenta) {
        CuentaBancaria cuentaBancaria = this.cuentas.get(numeroCuenta);
        cuentaBancaria.setExtranjero(esExtranjero);
    }
}
