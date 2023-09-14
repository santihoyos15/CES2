package ces2.entidades;

public class Barco extends Vehiculo {
    int carga = 0;
    String nombre;

    public String navegar () {
        return "Iniciando curso hacia España.";
    }

    @Override
    public String cargar(int carga) {
        this.carga += carga;
        return "Barco " + this.nombre + " cargado con " + this.carga + " toneladas.";
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
