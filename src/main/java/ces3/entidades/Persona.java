package ces3.entidades;

public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return "Persona con nombre: " + nombre + ".";
    }
}
