import framework.base.BaseTest;
import jdk.jfr.Name;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MtsMainPage;
import pages.ServicesInformationPage;

public class MainTest extends BaseTest {
    private String onlinePayText = "Онлайн пополнение без комиссии";
    private String servicePage = "Порядок оплаты и безопасность интернет платежей";
    private String phoneNumber = "(29)777-77-77";
    private String moneyAmount = "100.00";
    MtsMainPage mtsMainPage = new MtsMainPage();
    ServicesInformationPage servicesInformationPage = new ServicesInformationPage();

    @Name("Первый тест:")
    @Test(priority = 1)
    public void firstTaskTest() {
        mtsMainPage.clickCookiesButton();
        Assert.assertTrue(mtsMainPage.isOnPage(), "Вы не на главной странице сайта МТС");
        Assert.assertEquals(mtsMainPage.getOnlinePayLabelText(), onlinePayText);
    }

    @Name("Второй тест:")
    @Test(priority = 2)
    public void secondTaskTest() {
        Assert.assertTrue(mtsMainPage.paymentsLogoIsDisplayed(), "Логотипы платёжным методов не отображаются");
    }

    @Name("Третий тест:")
    @Test(priority = 3)
    public void thirdTaskTest() {
        mtsMainPage.clickDetailsButton();
        Assert.assertEquals(servicesInformationPage.getServiceLabelText(), servicePage);
        servicesInformationPage.clickMainPageButton();
    }

    @Name("Четвёртый тест:")
    @Test(priority = 4)
    public void fourthTaskTest() {
        mtsMainPage.chooseNeededCategory();
        mtsMainPage.makeOrderForFillTheBalance(phoneNumber, moneyAmount);
        mtsMainPage.switchToFrame();
        Assert.assertEquals(mtsMainPage.getMoneyAmountText(), moneyAmount);
    }
}