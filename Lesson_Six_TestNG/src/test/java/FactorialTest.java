import calculations.FactorialCalculation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @DataProvider(name = "dataForTest")
    public Object[][] dataArrayFactorial() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {5, 120},
                {10, 3628800}
        };
    }

    @Test(dataProvider = "dataForTest")
    public void testFactorial(int input, long expected) {
        assertEquals(FactorialCalculation.factorialCalculate(input), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumber() {
        FactorialCalculation.factorialCalculate(-15);
    }
}