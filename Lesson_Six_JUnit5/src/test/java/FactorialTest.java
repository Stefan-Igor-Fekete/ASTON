import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculations.FactorialCalculation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class FactorialTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void testFactorialOfZeroAndOne(int number) {
        assertEquals(1, FactorialCalculation.factorialCalculate(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2})
    void testFactorialOfTwo(int number) {
        assertEquals(2, FactorialCalculation.factorialCalculate(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    void testFactorialOfThree(int number) {
        assertEquals(6, FactorialCalculation.factorialCalculate(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4})
    void testFactorialOfFour(int number) {
        assertEquals(24, FactorialCalculation.factorialCalculate(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    void testFactorialOfFive(int number) {
        assertEquals(120, FactorialCalculation.factorialCalculate(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void testFactorialOfNegativeNumbers(int number) {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculation.factorialCalculate(number));
    }
}