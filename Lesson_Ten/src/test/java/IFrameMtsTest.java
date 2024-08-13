import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IFrameMtsTest extends BaseTest {
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
    SoftAssert softAssert = new SoftAssert();

    @Description("Проверяет корректность отображаемых надписей в пустых полях для различных категорий услуг")
    @Test
    public void checkTextInFieldsInAllCategory() {

        Allure.step("Проверяем, что находимся на главной странице сайта МТС");
        softAssert.assertTrue(mtsMainPage.isOnPage(), "Вы не на главной странице сайта МТС");

        Allure.step("Выбираем категорию 'Услуги связи'");
        mtsMainPage.chooseCommunicationServiceCategory();
        softAssert.assertEquals(mtsMainPage.getPhoneNumberLabelText(neededAttribute), phoneLabel, "Phone Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailLabelText(neededAttribute), emailLabel, "Email Label is incorrect");

        Allure.step("Выбираем категорию 'Домашний интернет'");
        mtsMainPage.chooseHomeInternetCategory();
        softAssert.assertEquals(mtsMainPage.getSubscriberPhoneText(neededAttribute), subscriberPhoneLabel, "Subscriber Phone Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailLabelText(neededAttribute), emailLabel, "Email Label is incorrect");

        Allure.step("Выбираем категорию 'Кредиты'");
        mtsMainPage.chooseCreditCategory();
        softAssert.assertEquals(mtsMainPage.getSubscriberCreditText(neededAttribute), subscriberCreditLabel, "Subscriber Credit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountCreditLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailCreditLabelText(neededAttribute), emailLabel, "Email Label is incorrect");

        Allure.step("Выбираем категорию 'Задолженность'");
        mtsMainPage.chooseDebtCategory();
        softAssert.assertEquals(mtsMainPage.getSubDebtText(neededAttribute), subDebtLabel, "Sub Debt Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountDebtLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailDebtLabelText(neededAttribute), emailLabel, "Email Label is incorrect");

        softAssert.assertAll();
    }

    @Test
    @Description("Проверяет корректность суммы на кнопке и надписей во всех незаполненных полях")
    public void checkTextAndPaymentsLogoInAllFields() {
        SoftAssert softAssert = new SoftAssert();

        Allure.step("Выбираем категорию 'Услуги связи' и вводим данные для пополнения баланса");
        mtsMainPage.chooseCommunicationServiceCategory();
        mtsMainPage.makeOrderForFillTheBalance(phoneNumber, moneyAmount);

        Allure.step("Переходим в iframe и проверяем отображаемую информацию");
        mtsMainPage.switchToFrame();
        softAssert.assertEquals(mtsMainPage.getMoneyAmountText(), moneyAmount, "Money amount field is incorrect");
        softAssert.assertEquals(mtsMainPage.getNumberIframeText(), phoneNumberIframe, "User number in field is incorrect");
        softAssert.assertEquals(mtsMainPage.getMoneyFromButton(), moneyAmount, "Money on the button is incorrect");
        softAssert.assertEquals(mtsMainPage.getTextCreditCardNumber(), cardNumber, "Card number is incorrect");
        softAssert.assertEquals(mtsMainPage.getTextCardDate(), cardDate, "Card date is incorrect");
        softAssert.assertEquals(mtsMainPage.getTextCvcCode(), cvcCode, "CVC-code is incorrect");
        softAssert.assertEquals(mtsMainPage.getCardOwnerName(), cardOwnerName, "Card owner name is incorrect");
        softAssert.assertTrue(mtsMainPage.arePaymentsIconsDisplayed(), "Payments logos doesn't shown");

        softAssert.assertAll();
    }
}