import framework.DriverStart;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MtsMainPage;
import pages.ServicesInformationPage;

public class BaseTest {
    protected MtsMainPage mtsMainPage;
    protected ServicesInformationPage servicesInformationPage;

    @BeforeMethod
    public void setUp() {
        DriverStart.getInstance();
        mtsMainPage = new MtsMainPage();
        servicesInformationPage = new ServicesInformationPage();
        mtsMainPage.clickCookiesButton();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverStart.quit();
    }
}