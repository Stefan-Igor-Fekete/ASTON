import framework.DriverStart;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MtsMainPage;

public class BaseTest {
    protected MtsMainPage mtsMainPage;

    @BeforeMethod
    public void setUp() {
        DriverStart.getInstance();
        mtsMainPage = new MtsMainPage();
        mtsMainPage.clickCookiesButton();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverStart.quit();
    }
}