package ces2.entidades;

public class Camion extends Vehiculo {
    String nombre;
    int carga = 0;

    public String iniciarRuta () {
        return "Conduciendo hacia Buenaventura";
    }

    @Override
    public String cargar(int carga) {
        this.carga += carga;
        return "Camion " + this.nombre + " cargado con " + this.carga + " toneladas.";
    }
    @Override
    public String localizar() {
        return "Camión en KM 65 de la autopista Medellín - Bogotá";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
