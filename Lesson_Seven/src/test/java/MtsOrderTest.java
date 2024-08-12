import jdk.jfr.Name;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MtsOrderTest extends BaseTest {
    private String onlinePayText = "Онлайн пополнение без комиссии";
    private String servicePage = "Порядок оплаты и безопасность интернет платежей";
    private String phoneNumber = "(29)777-77-77";
    private String moneyAmount = "100.00";

    @DataProvider(name = "logoIndexes")
    public Object[][] logoIndexes() {
        return new Object[][]{
                {0}, {1}, {2}, {3}, {4}
        };
    }

    @Name("Преверить название блока: 'Онлайн пополнение без комиссии' ")
    @Test
    public void onlinePAyLabelShownTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mtsMainPage.isOnPage(), "Вы не на главной странице сайта МТС");
        softAssert.assertEquals(mtsMainPage.getOnlinePayLabelText(), onlinePayText, "Текст метки 'Онлайн пополнение без комиссии' не совпадает.");
        softAssert.assertAll();
    }

    @Name("проверить наличие логотипов платёжных систем")
    @Test(dataProvider = "logoIndexes")
    public void allPaymentsLogoShownTest(int paymentLogosCapacity) {
        Assert.assertTrue(mtsMainPage.paymentsLogoIsDisplayed(paymentLogosCapacity), "Логотипы платёжным методов не отображаются");
    }

    @Name("Проверить работу ссылки: 'Подробнее о сервисе' ")
    @Test
    public void isServiceLinkWorkedTest() {
        mtsMainPage.clickDetailsButton();
        Assert.assertEquals(servicesInformationPage.getServiceLabelText(), servicePage);
    }

    @Name("Заполнить поля и проверить работу кнопки продолжить")
    @Test
    public void checkSubmitButtonWorkTest() {
        mtsMainPage.chooseNeededCategory();
        mtsMainPage.makeOrderForFillTheBalance(phoneNumber, moneyAmount);
        mtsMainPage.switchToFrame();
        Assert.assertEquals(mtsMainPage.getMoneyAmountText(), moneyAmount);
    }
}