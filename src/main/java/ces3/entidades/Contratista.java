package ces3.entidades;

import java.io.Serializable;

public class Contratista extends Persona implements Pago, Serializable {
    public Contratista(String nombre) {
        super(nombre);
    }

    @Override
    public String aumentarSalario(int porcentaje) {
        if (porcentaje > Pago.TOPE_AUMENTO) {
            return "Lo sentimos. No es posible aumentar el pago por encima del tope '" + Pago.TOPE_AUMENTO + "'";
        }

        return "Aumentando el salario en " + porcentaje + "% a " + this.getNombre();
    }
}
