package ces2.entidades;

public class Carro extends PedidoAbstracta{
    private Integer id;
    private Double precio;
    private String marca;
    private Integer idCliente;

    public Carro(Integer id, Double precio, String marca, Integer idCliente) {
        this.id = id;
        this.precio = precio;
        this.marca = marca;
        this.idCliente = idCliente;
    }

    public Integer getId() {
        return id;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    @Override
    public String mostrarInformacion() {
        return "Id: " + getId() + " Precio: " + getPrecio() + " Marca: " + getMarca() + " Cliente: " + getIdCliente();
    }
}
