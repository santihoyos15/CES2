package ces2.entidades;

public class Impuesto {
    double ingresoNeto;
    double impuestoGeneral;

    public void calcularImpuesto() {
        if (ingresoNeto < 30000) {
            impuestoGeneral = ingresoNeto * 0.05;
        } else {
            impuestoGeneral = ingresoNeto * 0.06;
        }
    }

    public double getIngresoNeto() {
        return ingresoNeto;
    }

    public void setIngresoNeto(double ingresoNeto) {
        this.ingresoNeto = ingresoNeto;
    }

    public double getImpuestoGeneral() {
        return impuestoGeneral;
    }

    public void setImpuestoGeneral(double impuestoGeneral) {
        this.impuestoGeneral = impuestoGeneral;
    }
}
