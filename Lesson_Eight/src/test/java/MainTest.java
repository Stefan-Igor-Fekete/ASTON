import framework.base.BaseTest;
import jdk.jfr.Name;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MtsMainPage;

public class MainTest extends BaseTest {
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
    MtsMainPage mtsMainPage = new MtsMainPage();

    @Name("Первый тест:")
    @Test(priority = 1)
    public void firstTaskTest() {
        mtsMainPage.clickCookiesButton();
        Assert.assertTrue(mtsMainPage.isOnPage(), "Вы не на главной странице сайта МТС");
        mtsMainPage.chooseCommunicationServiceCategory();
        Assert.assertEquals(mtsMainPage.getPhoneNumberLabelText(neededAttribute), phoneLabel);
        Assert.assertEquals(mtsMainPage.getDepositAmountLabelText(neededAttribute), depositLabel);
        Assert.assertEquals(mtsMainPage.getEmailLabelText(neededAttribute), emailLabel);
        mtsMainPage.chooseHomeInternetCategory();
        Assert.assertEquals(mtsMainPage.getSubscriberPhoneText(neededAttribute), subscriberPhoneLabel);
        Assert.assertEquals(mtsMainPage.getDepositAmountLabelText(neededAttribute), depositLabel);
        Assert.assertEquals(mtsMainPage.getEmailLabelText(neededAttribute), emailLabel);
        mtsMainPage.chooseCreditCategory();
        Assert.assertEquals(mtsMainPage.getSubscriberCreditText(neededAttribute), subscriberCreditLabel);
        Assert.assertEquals(mtsMainPage.getDepositAmountCreditLabelText(neededAttribute), depositLabel);
        Assert.assertEquals(mtsMainPage.getEmailCreditLabelText(neededAttribute), emailLabel);
        mtsMainPage.chooseDebtCategory();
        Assert.assertEquals(mtsMainPage.getSubDebtText(neededAttribute), subDebtLabel);
        Assert.assertEquals(mtsMainPage.getDepositAmountDebtLabelText(neededAttribute), depositLabel);
        Assert.assertEquals(mtsMainPage.getEmailDebtLabelText(neededAttribute), emailLabel);
    }

    @Name("Второй тест:")
    @Test(priority = 2)
    public void fourthTaskTest() {
        mtsMainPage.refreshMtsMainPage();
        mtsMainPage.chooseCommunicationServiceCategory();
        mtsMainPage.makeOrderForFillTheBalance(phoneNumber, moneyAmount);
        mtsMainPage.switchToFrame();
        Assert.assertEquals(mtsMainPage.getMoneyAmountText(), moneyAmount);
        Assert.assertEquals(mtsMainPage.getNumberIframeText(), phoneNumberIframe);
        Assert.assertEquals(mtsMainPage.getMoneyFromButton(), moneyAmount);
        Assert.assertEquals(mtsMainPage.getTextCreditCardNumber(), cardNumber);
        Assert.assertEquals(mtsMainPage.getTextCardDate(), cardDate);
        Assert.assertEquals(mtsMainPage.getTextCvcCode(), cvcCode);
        Assert.assertEquals(mtsMainPage.getCardOwnerName(), cardOwnerName);
        Assert.assertTrue(mtsMainPage.arePaymentsIconsDisplayed());
    }
}