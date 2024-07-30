import calculations.FactorialCalculation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @DataProvider(name = "dataForTest")
    public Object[][] dataArrayFactorial() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {19, 121645100408832000L},
                {20, 2432902008176640000L}
        };
    }

    @Test(dataProvider = "dataForTest")
    public void testFactorial(int input, long expected) {
        long result = FactorialCalculation.factorial(input);
        Assert.assertEquals(result, expected, "Факториал числа:  " + input + "  должен равняться - " + expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        FactorialCalculation.factorial(-1);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testFactorialOverflow() {
        FactorialCalculation.factorial(21);
    }
}