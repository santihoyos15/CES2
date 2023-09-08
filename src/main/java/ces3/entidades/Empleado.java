package ces3.entidades;

public class Empleado extends Persona {

    public Empleado(String nombre) {
        super(nombre);
    }

    public String aumentarSalario(int porcentaje) {
        return "Aumentando el salario en " + porcentaje + "% a " + this.getNombre() + "<br/>";
    }
}
