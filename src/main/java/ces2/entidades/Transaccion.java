package ces2.entidades;

public class Transaccion {
    private Integer tipo;
    private Double monto;

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String toString () {
        return TipoTransaccion.getById(tipo).getName() + ": " + monto;
    }
}
