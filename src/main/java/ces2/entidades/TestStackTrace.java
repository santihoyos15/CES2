package ces2.entidades;

import java.io.IOException;

public class TestStackTrace {
    public TestStackTrace() throws ArithmeticException {
        dividirPorCero();
    }

    public double dividirPorCero() throws ArithmeticException {
        return 25 / 0;
    }
}
