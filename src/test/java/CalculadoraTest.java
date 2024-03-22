import org.example.Calculadora;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CalculadoraTest {
    @Test
    public void isGreaterTestOk() {
        System.out.println("Test");
        Calculadora calculadora = new Calculadora();
        assertTrue("Num 1 is greater than Num 2", calculadora.isGreater(4, 3));

    }
    @Test
    public void isGreaterTestEqualFail() {
        System.out.println("Test");
        Calculadora calculadora = new Calculadora();

        assertFalse("Num 1 is greater than Num 2", calculadora.isGreater(3, 3));

    }
}