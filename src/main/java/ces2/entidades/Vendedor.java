package ces2.entidades;

public class Vendedor {
    private Integer codigo;
    private String ciudad;
    private double ventas;

    public Vendedor(int codigo, String ciudad) {
        this.codigo = codigo;
        this.ciudad = ciudad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }
}
