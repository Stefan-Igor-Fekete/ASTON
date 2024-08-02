package framework.base;

import framework.DriverStart;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        DriverStart.getInstance();
    }

    @AfterTest
    public void tearDown() {
        DriverStart.quit();
    }
}