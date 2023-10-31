package ces2.entidades;

import java.util.HashMap;

public class Banco {
    public Auditoria auditoria;
    private HashMap<Integer, CuentaBancaria> cuentas;
    private int siguienteCuenta;
    public ReportGenerator reportGenerator;

    public Banco () {
        this.cuentas = new HashMap<>();
        this.siguienteCuenta = 1000;
        this.reportGenerator = new ReportGenerator(this);
        this.auditoria = new Auditoria(this);
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

    public double getBalance (int numeroCuenta) {
        return cuentas.get(numeroCuenta).getBalance();
    }

    public void depositar (double cantidad, int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);
        cuenta.depositar(cantidad);
    }

    public void retirar(double cantidad, int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);
        cuenta.retirar(cantidad);
    }

    public boolean autorizarPrestamo (double cantidad, int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);
        if (!cuenta.tieneGarantia(cantidad)) {
            return false;
        }

        cuenta.autorizarPrestamo(cantidad);
        return true;
    }

    public boolean addInteres (int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);

        if (!(cuenta instanceof CuentaDeAhorros)) {
            return false;
        }

        CuentaDeAhorros cuentaAhorros = (CuentaDeAhorros) cuenta;
        cuentaAhorros.addInteres();

        return true;
    }

    public HashMap<Integer, CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void cambiarNacionalidad(boolean esExtranjero, int numeroCuenta) {
        CuentaBancaria cuentaBancaria = this.cuentas.get(numeroCuenta);
        cuentaBancaria.setExtranjero(esExtranjero);
    }

    public CuentaBancaria getCuenta (int numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }
}
