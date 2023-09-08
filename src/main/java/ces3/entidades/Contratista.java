package ces3.entidades;

public class Contratista extends Persona {
    public Contratista(String nombre) {
        super(nombre);
    }

    public String aumentarSalario(int porcentaje) {
        if (porcentaje > this.TOPE_AUMENTO) {
            return "Lo sentimos. No es posible aumentar el pago por hora por encima de " + this.TOPE_AUMENTO + "% a " + this.getNombre() + "<br/>";
        }

        return "Aumentando el pago por hora en " + porcentaje + "% a " + this.getNombre() + "<br/>";
    }
}
