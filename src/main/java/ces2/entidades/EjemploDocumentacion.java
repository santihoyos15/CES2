package ces2.entidades;

import java.text.DecimalFormat;

/**
 * <h1>Hello</h1>
 * <p>This is is wonderful</p>
 * @version 1.2 18/11/2023
 * @author Santiago Hoyos
 * @see javax.swing.table.DefaultTableModel
 * */
public class EjemploDocumentacion {
    private double x;
    private double y;
    private double z;

    public EjemploDocumentacion(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Calcula la distancia desde el origen hasta el punto (x, y, z).
     * @param x La distancia de el punto a largo del x.
     * @param y La distancia de el punto a largo del y.
     * @param z La distancia de el punto a largo del z.
     * @return La distancia desde el origen a el punto (x, y, z). Valor no negativo.
     * */
    public double distancia (double x, double y, double z) {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * Formatea un valor decimal para que quede con un solo digito después del punto.
     * Si el digito despues del punto es 0, solo se retorna el numero en String.
     * @param input El valor a ser formateado.
     * @return Un String que representa el parametro input con un digito decimal.
     * */
    public String format(double input) {
        DecimalFormat df = new DecimalFormat("0.#");
        return df.format(input);
    }
}
