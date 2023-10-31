package ces2.entidades;

import java.util.Arrays;

public enum TipoTransaccion {
    RETIRO(1, "Retiro"),
    DEPOSITO(2, "Deposito"),
    PRESTAMO(3, "Prestamo");

    private Integer index;
    private String name;

    TipoTransaccion(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static TipoTransaccion getById(Integer id) {
        return Arrays.stream(TipoTransaccion.values())
                .filter(tipo -> tipo.index.equals(id))
                .findFirst()
                .orElse(null);
    }
}
