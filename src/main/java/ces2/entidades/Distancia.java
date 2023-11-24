package ces2.entidades;

public class Distancia extends EjemploDocumentacion {
    final float PI = 3.14f;
    public Distancia(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public double distancia (double x, double y, double z) {
        double resultado = super.distancia(x, y, z);
        return resultado * PI;
    }
}
