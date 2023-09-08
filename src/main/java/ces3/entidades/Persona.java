package ces3.entidades;

public abstract class Persona {
    private String nombre;
    private String direccion;

    int TOPE_AUMENTO = 20;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String setDireccion (String direccion) {
        this.direccion = direccion;
        return "La nueva dirección es: " + this.direccion;
    }

    private String darDiaLibre () {
        return "Dando un día libre a la persona: " + this.nombre + "<br />";
    }

    public String ascender (int porcentajeAumento) {
        String html = "";
        html += this.darDiaLibre();
        html += this.aumentarSalario(porcentajeAumento);
        html += "Ascendiendo a la persona: " + this.nombre + "<br />";

        return html;
    }

    public abstract String aumentarSalario (int porcentajeAumento);

}
