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

    public double getBalance (int numeroCuenta) {
        return cuentas.get(numeroCuenta).getBalance();
    }

    public void depositar (double cantidad, int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);
        cuenta.depositar(cantidad);
    }

    public boolean autorizarPrestamo (double cantidad, int numeroCuenta) {
        CuentaBancaria cuenta = cuentas.get(numeroCuenta);
        if (!cuenta.tieneGarantia(cantidad)) {
            return false;
        }

        cuenta.depositar(cantidad);
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

    public String imprimirInformacionTodasCuentas () { return "";
    };

    public String imprimirInformacionUnaCuenta (int numcta) { return "";
    }

    public String imprimirCuentaConMayorBalance() { return "";
    };

    public String imprimirCuentaConMenorBalance() { return "";
    };

    public String mostrarTodosMovimientosCuenta (int numcta) { return "";
    }

    public String mostrarUltimoMovimientoCuenta (int numcta) { return "";
    }
}
