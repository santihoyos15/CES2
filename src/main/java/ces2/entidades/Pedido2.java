package ces2.entidades;

import java.util.List;

public class Pedido2 {
    public String procesarDatos(List<? extends PedidoAbstracta> pedidos) {
        String salida = "";

        for (PedidoAbstracta pedido: pedidos) {
            salida += pedido.mostrarInformacion() + "<br />";
        }

        return salida;
    }
}
