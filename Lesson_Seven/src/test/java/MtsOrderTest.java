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
    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "logoIndexes")
    public Object[][] logoIndexes() {
        int logoCount = mtsMainPage.getCountOfPaymentFields();
        int[] indexes = new int[logoCount];
        for (int i = 0; i < logoCount; i++) {
            indexes[i] = i;
        }
        return new Object[][]{{indexes}};
    }

    @Name("Преверить название блока: 'Онлайн пополнение без комиссии' ")
    @Test
    public void onlinePAyLabelShownTest() {
        softAssert.assertTrue(mtsMainPage.isOnPage(), "Вы не на главной странице сайта МТС");
        softAssert.assertEquals(mtsMainPage.getOnlinePayLabelText(), onlinePayText, "Текст метки 'Онлайн пополнение без комиссии' не совпадает.");
        softAssert.assertAll();
    }

    @Name("Проверить наличие логотипов платёжных систем")
    @Test(dataProvider = "logoIndexes")
    public void allPaymentsLogoShownTest(int[] indexes) {
        for (int index : indexes) {
            softAssert.assertTrue(mtsMainPage.paymentsLogoIsDisplayed(index),
                    "Логотип платёжного метода под индексом " + index + " не отображается");
        }
        softAssert.assertAll();
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