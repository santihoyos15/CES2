package ces3.entidades;

public class Barco implements VehiculoCarga, Localizable {
    int carga = 0;
    String nombre;

    public String navegar () {
        return "Iniciando curso hacia España.";
    }

    @Override
    public String cargar(int carga) {
        this.carga += carga;
        return "Barco cargado con" + this.carga + "toneladas.";
    }

    @Override
    public String localizar() {
        return "Barco cruzando el pacífico.";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
