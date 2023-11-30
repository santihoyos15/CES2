package ces2.entidades;

public class Cliente {
    public String nombre;
    public double ingresoNeto;
    private char  status;

    public Cliente(String nombre, char status) {
        this.nombre = nombre;
        this.status = status;
    }

    public String funcionCalculoImpuesto (FuncionalImpuesto ingreso) {
        double impuesto = ingreso.calcImp(ingresoNeto);
        return "el impuesto calculado para " + nombre + " es " + impuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public char getStatus() {
        return status;
    }

}
