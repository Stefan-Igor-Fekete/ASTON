import framework.DriverStart;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MtsMainPage;
import pages.ServicesInformationPage;

public class BaseTest {
    protected MtsMainPage mtsMainPage = new MtsMainPage();
    protected ServicesInformationPage servicesInformationPage = new ServicesInformationPage();

    @BeforeMethod
    public void setUp() {
        DriverStart.getInstance();
        mtsMainPage.clickCookiesButton();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverStart.quit();
    }
}