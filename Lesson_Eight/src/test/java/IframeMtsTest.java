import jdk.jfr.Name;
import org.testng.Assert;
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

    @Name("Проверить надписи в незаполненных полях каждого варианта оплаты услуг")
    @Test
    public void firstTaskTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mtsMainPage.isOnPage(), "Вы не на главной странице сайта МТС");
        mtsMainPage.chooseCommunicationServiceCategory();
        softAssert.assertEquals(mtsMainPage.getPhoneNumberLabelText(neededAttribute), phoneLabel, "Phone Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailLabelText(neededAttribute), emailLabel, "Email Label is incorrect");
        mtsMainPage.chooseHomeInternetCategory();
        softAssert.assertEquals(mtsMainPage.getSubscriberPhoneText(neededAttribute), subscriberPhoneLabel, "Subscriber Phone Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailLabelText(neededAttribute), emailLabel, "Email Label is incorrect");
        mtsMainPage.chooseCreditCategory();
        softAssert.assertEquals(mtsMainPage.getSubscriberCreditText(neededAttribute), subscriberCreditLabel, "Subscriber Credit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountCreditLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailCreditLabelText(neededAttribute), emailLabel, "Email Label is incorrect");
        mtsMainPage.chooseDebtCategory();
        softAssert.assertEquals(mtsMainPage.getSubDebtText(neededAttribute), subDebtLabel, "Sub Debt Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getDepositAmountDebtLabelText(neededAttribute), depositLabel, "Deposit Label is incorrect");
        softAssert.assertEquals(mtsMainPage.getEmailDebtLabelText(neededAttribute), emailLabel, "Email Label is incorrect");
        softAssert.assertAll();
    }

    @Name("Проверка суммы на кнопке, а так же надписей во всех незаполненных поолях")
    @Test
    public void fourthTaskTest() {
        SoftAssert softAssert = new SoftAssert();
        mtsMainPage.chooseCommunicationServiceCategory();
        mtsMainPage.makeOrderForFillTheBalance(phoneNumber, moneyAmount);
        mtsMainPage.switchToFrame();
        softAssert.assertEquals(mtsMainPage.getMoneyAmountText(), moneyAmount);
        softAssert.assertEquals(mtsMainPage.getNumberIframeText(), phoneNumberIframe);
        softAssert.assertEquals(mtsMainPage.getMoneyFromButton(), moneyAmount);
        softAssert.assertEquals(mtsMainPage.getTextCreditCardNumber(), cardNumber);
        softAssert.assertEquals(mtsMainPage.getTextCardDate(), cardDate);
        softAssert.assertEquals(mtsMainPage.getTextCvcCode(), cvcCode);
        softAssert.assertEquals(mtsMainPage.getCardOwnerName(), cardOwnerName);
        softAssert.assertTrue(mtsMainPage.arePaymentsIconsDisplayed());
        softAssert.assertAll();
    }
}