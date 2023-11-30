package ces2.entidades;

public class Impuesto2 {
    public static double calcularImpuesto(double ingresoNeto) {
        if (ingresoNeto < 30000) {
            return ingresoNeto * 0.05;
        }

        return ingresoNeto * 0.06;
    }
}
