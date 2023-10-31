package ces2.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportGenerator {
    private Banco banco;
    public ReportGenerator(Banco banco) {
        if (banco == null) throw new RuntimeException("Banco required");

        this.banco = banco;
    }

    public String imprimirInformacionTodasCuentas () {
        List<CuentaBancaria> cuentas = new ArrayList<>(banco.getCuentas().values());

        String report = "";

        for (CuentaBancaria cuenta : cuentas) {
            report += cuenta.toString() + "<br />";
        }

        return report;
    };

    public String imprimirInformacionUnaCuenta (int numcta) {
        CuentaBancaria cuenta = banco.getCuenta(numcta);

        if (cuenta == null) {
            return "Cuenta no encontrada";
        }

        return cuenta.toString();
    }

    public String imprimirCuentaConMayorBalance() {
        List<CuentaBancaria> cuentas = new ArrayList<>(banco.getCuentas().values());

        return Collections.max(cuentas).toString();
    };

    public String imprimirCuentaConMenorBalance() {
        List<CuentaBancaria> cuentas = new ArrayList<>(banco.getCuentas().values());

        return Collections.min(cuentas).toString();
    };
}
