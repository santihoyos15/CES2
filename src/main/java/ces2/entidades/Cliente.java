package ces2.entidades;

public class Cliente extends PedidoAbstracta {
    private Integer id;
    private String nombre;
    private String celular;
    private Boolean comprar;

    public Cliente(Integer id, String nombre, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.comprar = false;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCelular() {
        return celular;
    }

    public Boolean getComprar() {
        return comprar;
    }

    public void comprarCarro(Boolean opcion) {
        this.comprar = opcion;
    }

    @Override
    public String mostrarInformacion() {
        return "Id: " + getId() + " Nombre: " + getNombre() + " Comprar: " + getComprar();
    }
}
