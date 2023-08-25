package ces3.entidades;

public class Empleado extends Persona implements Pago {

    double limite = Pago.verificarLimiteAumentoSalario();

    public Empleado(String nombre) {
        super(nombre);
    }

    @Override
    public String aumentarSalario(int porcentaje) {
        return "Aumentando el salario en " + porcentaje + "% a " + this.getNombre();
    }
}
