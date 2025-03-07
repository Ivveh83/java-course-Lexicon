package Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testAddition() {
        assertEquals(5, Main.makeCalculation(2, 3, 0, '+'));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, Main.makeCalculation(5, 3, 0, '-'));
    }

    @Test
    void testMultiplication() {
        assertEquals(15, Main.makeCalculation(3, 5, 0, '*'));
    }

    @Test
    void testDivision() {
        assertEquals(2, Main.makeCalculation(10, 5, 0, '/'));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Main.makeCalculation(10, 0, 0, '/'));
    }
}
