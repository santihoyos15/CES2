package ces2.entidades;

public class Contratista extends Persona {

    public Contratista(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String aumentarSalario(int porcentajeAumento) {
        if (porcentajeAumento > TOPE_AUMENTO) {
            return "Lo sentimos no es posible aumentar el pago por hora más de " + TOPE_AUMENTO + "%. A " + this.getNombre() + "<br/>";
        }

        return "Aumentando el pago por hora un " + porcentajeAumento + "% a " + this.getNombre() + "<br/>";
    }
}
