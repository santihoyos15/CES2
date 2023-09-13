package ces3.entidades;

public class Avion implements VehiculoCarga, Localizable {
    String nombre;
    int carga = 0;

    public String volar () {
        return "Despegando hacia Miami.";
    }

    @Override
    public String cargar(int carga) {
        this.carga += carga;
        return "Avión cargado con" + this.carga + "toneladas.";
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
