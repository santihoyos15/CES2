package ces3.entidades;

public class Avion extends Vehiculo {
    String nombre;
    int carga = 0;

    public String volar () {
        return "Despegando hacia Miami.";
    }

    @Override
    public String cargar(int carga) {
        this.carga += carga;
        return "Avión " + this.nombre + " cargado con " + this.carga + " toneladas.";
    }

    @Override
    public String localizar() {
        return "Avión cruzando el atlantico.";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
