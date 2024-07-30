import static org.junit.jupiter.api.Assertions.*;

import calculations.FactorialCalculation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120",
            "19, 121645100408832000",
            "20, 2432902008176640000"
    })
    public void testFactorial(int input, long expected) {
        long result = FactorialCalculation.factorial(input);
        assertEquals(expected, result, "Factorial of " + input + " should be " + expected);
    }

    @Test
    public void testFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculation.factorial(-1));
    }

    @Test
    public void testFactorialOverflow() {
        assertThrows(ArithmeticException.class, () -> FactorialCalculation.factorial(21));
    }
}
