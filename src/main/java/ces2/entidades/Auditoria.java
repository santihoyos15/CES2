package ces2.entidades;

public class Auditoria {
    private Banco banco;
    public Auditoria (Banco banco) {
        if (banco == null) throw new RuntimeException("Banco required");

        this.banco = banco;
    }

    public String mostrarTodosMovimientosCuenta (int numcta) {
        CuentaBancaria cuenta = banco.getCuenta(numcta);

        if (cuenta == null) {
            return null;
        }

        String out = "";

        if (cuenta.getTransacciones().isEmpty()) {
            out = "Sin transacciones";
        } else {
            for (Transaccion transaccion: cuenta.getTransacciones()) {
                out += transaccion.toString() + "<br/>";
            };
        }

        return out;
    }

    public Transaccion mostrarUltimoMovimientoCuenta (int numcta) {
        CuentaBancaria cuenta = banco.getCuenta(numcta);

        if (cuenta == null) {
            return null;
        }

        return cuenta.getUltimaTransaccion();
    }
}
