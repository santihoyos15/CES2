package ces3.entidades;

public interface Pago {
    int TOPE_AUMENTO = 20;

    default String aumentarSalario(int porcentaje) {
        return "Hola, Quieres que te aumente el salario?";
    }

    static double verificarLimiteAumentoSalario () {
        return 300000;
    }
}
