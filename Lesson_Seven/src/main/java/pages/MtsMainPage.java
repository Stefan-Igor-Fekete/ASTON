package pages;

import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.DropDownList;
import framework.elements.Label;
import framework.elements.TextField;
import framework.enums.MtsPaymentCategory;
import framework.utils.StringUtils;
import org.openqa.selenium.By;

import static framework.base.BaseElement.switchToFrameByFrameIndexAndWait;

public class MtsMainPage extends BasePage {
    private static String mtsMainPage = "Главная страница МТС";
    private int frameIndex = 0;
    private static Label mtsOnlinePayLabel = new Label(By.xpath("//div[@class='pay__wrapper']//h2"),
            "Поле онлайн платежей");
    private static Label paymentsLogo = new Label(By.xpath("//div[@class='pay__partners']"),
            "Поле логотипов платёжных сервисов");
    private static Label moneyCapacityLabel = new Label(By.xpath("(//div[@class='payment-page__order-description pay-description']//span)[1]"),
            "Количество введённых денег");
    private static TextField depositAmount = new TextField(By.xpath("//input[@id='connection-sum']"),
            "Поле: введите сумму");
    private static TextField phoneField = new TextField(By.xpath("//input[@id='connection-phone']"),
            "Поле: введите номер");
    private static Button categoryPaymentList = new Button(By.xpath("//button[@class='select__header']"),
            "Кнопка выбора категории для оплаты");
    private static DropDownList categoryList = new DropDownList(By.xpath(String.format("//p[contains(text(), '%s')]",
            MtsPaymentCategory.COMMUNICATION_SERVICES.getValue())), "Категория: услуги связи");
    private static Button continueButton = new Button(By.xpath("//form[@id='pay-connection']//button[@class='button button__default ']"),
            "Кнопка продолжить");
    private static Button cookieOkButton = new Button(By.xpath("//button[@id='cookie-agree']"),
            "Кнопка принятия куки");
    public static Button detailsAboutServices = new Button(By.xpath("//div[@class='pay__wrapper']//a[contains(text(), 'сервисе')]"),
            "Кнопка информации  о сервисах");

    public MtsMainPage() {
        super(mtsOnlinePayLabel, mtsMainPage);
    }

    public void clickCookiesButton() {
        cookieOkButton.waitDisplayedAndClick();
    }

    public String getOnlinePayLabelText() {
        return StringUtils.lineWithoutHyphenation(mtsOnlinePayLabel.getTextFrom());
    }

    public boolean paymentsLogoIsDisplayed() {
        return paymentsLogo.isDisplayed();
    }

    public void clickDetailsButton() {
        detailsAboutServices.waitDisplayedAndClick();
    }

    public void makeOrderForFillTheBalance(String phoneNumber, String moneyAmount) {
        phoneField.sendText(phoneNumber);
        depositAmount.sendText(moneyAmount);
        continueButton.waitAndClick();
    }

    public String getMoneyAmountText() {
        String abc = moneyCapacityLabel.getTextFrom();
        return abc.replaceAll("[^0-9.]", "");
    }

    public void switchToFrame() {
        switchToFrameByFrameIndexAndWait(frameIndex);
    }

    public void chooseNeededCategory() {
        categoryPaymentList.waitAndClick();
        categoryList.waitAndClick();
    }
}