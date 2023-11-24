package ces2.entidades;

public class Empleado extends Persona {

    public String name;
    @Override
    public String aumentarSalario() {
        return "Aumentando el salario para el empleado...";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
