package ces2.entidades;

public abstract class Persona {
    public final int TOPE_AUMENTO = 5;
    public final int TOPE_DIAS = 3;
    public final int MAXIMA_DURACION_CONTRATO_MESES = 6;

    private int id;
    private String nombre;
    private Integer diasLibres;
    public Integer duracionContratoMeses;

    // todo you're done, just make sure new changes work
    public Persona(int id, String nombre, int duracionContratoMeses) {
        this.id = id;
        this.nombre = nombre;
        this.duracionContratoMeses = duracionContratoMeses;
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

    public Integer getDuracionContratoMeses() {
        return duracionContratoMeses;
    }

    public void setDuracionContratoMeses(Integer duracionContratoMeses) {
        this.duracionContratoMeses = duracionContratoMeses;
    }
}
