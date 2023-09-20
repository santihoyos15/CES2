package ces2.entidades;

public abstract class Persona {
    public final int TOPE_AUMENTO = 5;
    public final int TOPE_DIAS = 3;

    private int id;
    private String nombre;
    private Integer diasLibres;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public abstract String aumentarSalario (int porcentajeAumento);

    public String darDiaLibre () {
        return "Dando un dia libre a " + this.nombre + "<br />";
    }

    public String ascender (int porcentajeAumento) {
        String salida = "";
        salida += darDiaLibre();

        salida += aumentarSalario(porcentajeAumento);
        salida += "Dando un ascenso a " + this.nombre + "<br />";
        return salida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiasLibres() {
        if (this.diasLibres == null) {
            return "No tiene dias libres";
        }

        return this.diasLibres.toString();
    }

    public String setDiasLibres(int diasLibres) {
        if (diasLibres > TOPE_DIAS) {
            return this.getNombre() + " no puede tener mas de " + TOPE_DIAS + " dias libres";
        }

        this.diasLibres = diasLibres;
        return "OK";

    }
}