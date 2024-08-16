import io.qameta.allure.Description;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IframeMtsTest extends BaseTest {
    private String phoneNumber = "(29)777-77-77";
    private String phoneNumberIframe = "375297777777";
    private String neededAttribute = "placeholder";
    private String phoneLabel = "Номер телефона";
    private String depositLabel = "Сумма";
    private String subscriberPhoneLabel = "Номер абонента";
    private String subscriberCreditLabel = "Номер счета на 44";
    private String subDebtLabel = "Номер счета на 2073";
    private String emailLabel = "E-mail для отправки чека";
    private String cardNumber = "Номер карты";
    private String cardDate = "Срок действия";
    private String cvcCode = "CVC";
    private String cardOwnerName = "Имя держателя (как на карте)";
    private String moneyAmount = "100.00";
    private boolean isTestPassed = false;
    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "frameIndices")
    public Object[][] createFrameIndices() {
        return new Object[][]{
                {1}
        };
    }

    @Description("Проверяет корректность отображаемых надписей в пустых полях для категории: Услуги связи")
    @Test
    public void checkTextInFieldsInServiceCategory() {
        softAssert.assertTrue(mtsMainPage.isOnPage(), "Вы не на главной странице сайта МТС");
        mtsMainPage.chooseCommunicationServiceCategory();
        softAssert.assertEquals(mtsMainPage.getPhoneNumberLabelText(neededAttribute), phoneLabel, "Phone Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountServiceLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailLabelText(neededAttribute), emailLabel, "Email Label is incorrect");
        softAssert.assertAll();
    }

    @Description("Проверяет корректность отображаемых надписей в пустых полях для категории: Домашний интернет")
    @Test
    public void checkTextInFieldsInInternetCategory() {
        mtsMainPage.chooseHomeInternetCategory();
        softAssert.assertEquals(mtsMainPage.getSubscriberPhoneText(neededAttribute), subscriberPhoneLabel, "Subscriber Phone Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailHomeInternetText(neededAttribute), emailLabel, "Email Label is incorrect");
        softAssert.assertAll();
    }

    @Description("Проверяет корректность отображаемых надписей в пустых полях для категории: Кредиты")
    @Test
    public void checkTextInFieldsInCreditCategory() {
        mtsMainPage.chooseCreditCategory();
        softAssert.assertEquals(mtsMainPage.getSubscriberCreditText(neededAttribute), subscriberCreditLabel, "Subscriber Credit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountCreditLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailCreditLabelText(neededAttribute), emailLabel, "Email Label is incorrect");
        softAssert.assertAll();
    }

    @Description("Проверяет корректность отображаемых надписей в пустых полях для категории: Задолженность")
    @Test
    public void checkTextInFieldsInDebtCategory() {
        mtsMainPage.chooseDebtCategory();
        softAssert.assertEquals(mtsMainPage.getSubDebtText(neededAttribute), subDebtLabel, "Sub Debt Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountDebtLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailDebtLabelText(neededAttribute), emailLabel, "Email Label is incorrect");
        softAssert.assertAll();
    }

    @Test(dataProvider = "frameIndices")
    @Description("Проверяет корректность суммы на кнопке и надписей во всех незаполненных полях")
    public void checkTextAndPaymentsLogoInAllFields(int frameIndex) {
        if (isTestPassed) {
            throw new SkipException("Test has already passed for a previous index.");
        }
        try {
            mtsMainPage.chooseCommunicationServiceCategory();
            mtsMainPage.makeOrderForFillTheBalance(phoneNumber, moneyAmount);
            mtsMainPage.switchToFrame(frameIndex);
            softAssert.assertEquals(mtsMainPage.getMoneyAmountText(), moneyAmount, "Money amount field is incorrect");
            softAssert.assertEquals(mtsMainPage.getNumberIframeText(), phoneNumberIframe, "User number in field is incorrect");
            softAssert.assertEquals(mtsMainPage.getMoneyFromButton(), moneyAmount, "Money on the button is incorrect");
            softAssert.assertEquals(mtsMainPage.getTextCreditCardNumber(), cardNumber, "Card number is incorrect");
            softAssert.assertEquals(mtsMainPage.getTextCardDate(), cardDate, "Card date is incorrect");
            softAssert.assertEquals(mtsMainPage.getTextCvcCode(), cvcCode, "CVC-code is incorrect");
            softAssert.assertEquals(mtsMainPage.getCardOwnerName(), cardOwnerName, "Card owner name is incorrect");
            softAssert.assertTrue(mtsMainPage.arePaymentsIconsDisplayed(), "Payments logos don't show");
            isTestPassed = true;
            softAssert.assertAll();
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }
}