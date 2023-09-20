package ces2.entidades;

public class Empleado extends Persona {

    public Empleado(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String aumentarSalario(int porcentajeAumento) {
        return "Aumentando el salario un " + porcentajeAumento + "% a " + this.getNombre() + "<br/>";
    }
}
