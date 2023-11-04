package ces2.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedidos<T> {
    private List<T> pedidos = new ArrayList<>();

    public void add(T t) {
        pedidos.add(t);
    }

    public List<T> getPedidos() {
        return pedidos;
    }


}