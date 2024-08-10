package pages;

import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.DropDownList;
import framework.elements.Label;
import framework.elements.TextField;
import framework.enums.MtsPaymentCategory;
import org.openqa.selenium.By;

import static framework.base.BaseElement.switchToFrameByFrameIndexAndWait;

public class MtsMainPage extends BasePage {
    private static String mtsMainPage = "Главная страница МТС";
    private int frameIndex = 1;
    private static Label moneyCapacityIframeLabel = new Label(By.xpath("(//div[@class='payment-page__order-description pay-description']//span)[1]"),
            "Количество введённых денег на панели iFrame");
    private static Label clientNumberIframeLabel = new Label(By.xpath("//div[@class='pay-description__text']"),
            "Количество введённых денег");
    private static Label mtsOnlinePayLabel = new Label(By.xpath("//div[@class='pay__wrapper']//h2"),
            "Лэйбл проверки главной страницы");
    private static Label phoneNumberLabel = new Label(By.xpath("//input[@id='connection-phone']"),
            "Текст внутри поля: Номер телефона");
    private static Label depositAmountCreditLabel = new Label(By.xpath("//input[@id='instalment-sum']"),
            "Текст внутри поля: Сумма");
    private static Label emailAdressCreditLabel = new Label(By.xpath("//input[@id='instalment-email']"),
            "Текст внутри поля: E-mail для отправки чека");
    private static Label depositAmountLabel = new Label(By.xpath("//input[@id='connection-sum']"),
            "Текст внутри поля: Сумма");
    private static Label depositAmountDebtLabel = new Label(By.xpath("//input[@id='instalment-sum']"),
            "Текст внутри поля: Сумма");
    private static Label emailAdressDebtLabel = new Label(By.xpath("//input[@id='instalment-email']"),
            "Текст внутри поля: E-mail для отправки чека");
    private static Label emailAdressLabel = new Label(By.xpath("//input[@id='connection-email']"),
            "Текст внутри поля: E-mail для отправки чека");
    private static Label subscriberPhoneLabel = new Label(By.xpath("//input[@id='internet-phone']"),
            "Текст внутри поля: E-mail для отправки чека");
    private static Label subscriberCreditLabel = new Label(By.xpath("//input[@id='score-instalment']"),
            "Текст внутри поля: Номер счета на 44");
    private static Label subDebtLabel = new Label(By.xpath("//input[@id='score-arrears']"),
            "Текст внутри поля: Номер счета на 2073");
    private static Label iframeCardNumber = new Label(By.xpath("//div[@class='content ng-tns-c46-1']"),
            "Текст внутри поля в iFrame: Номер карты");
    private static Label iframeCardDate = new Label(By.xpath("//div[@class='content ng-tns-c46-4']"),
            "Текст внутри поля в iFrame: Срок действия");
    private static Label iframeCvcCard = new Label(By.xpath("//div[@class='content ng-tns-c46-5']"),
            "Текст внутри поля в iFrame: CVC");
    private static Label iframePaymentsMethod = new Label(By.xpath("//div[@class='cards-brands ng-tns-c46-1']"),
            "Значки способов оплаты на iFrame");
    private static Label iframeCardHolderName = new Label(By.xpath("//div[@class='content ng-tns-c46-3']"),
            "Текст внутри поля iFrame: Имя держателя (как на карте)");
    private static TextField depositAmount = new TextField(By.xpath("//input[@id='connection-sum']"),
            "Поле: Сумма");
    private static TextField phoneField = new TextField(By.xpath("//input[@id='connection-phone']"),
            "Поле: Номер телефона");
    private static DropDownList categoryPaymentList = new DropDownList(By.xpath("//button[@class='select__header']"),
            "Выпадающий список выбора категорий для оплаты");
    private static Button communicationServiceCategory = new Button(By.xpath(String.format("//p[contains(text(), '%s')]",
            MtsPaymentCategory.COMMUNICATION_SERVICES.getValue())), "Категория: Услуги связи");
    private static Button homeInternetCategory = new Button(By.xpath(String.format("//p[contains(text(), '%s')]",
            MtsPaymentCategory.HOME_INTERNET.getValue())), "Категория: Домашний интренет");
    private static Button creditCategory = new Button(By.xpath(String.format("//p[contains(text(), '%s')]",
            MtsPaymentCategory.CREDIT.getValue())), "Категория: Рассрочка");
    private static Button debtCategory = new Button(By.xpath(String.format("//p[contains(text(), '%s')]",
            MtsPaymentCategory.DEBT.getValue())), "Категория: Задолженность");
    private static Button continueButton = new Button(By.xpath("//form[@id='pay-connection']//button[@class='button button__default ']"),
            "Кнопка продолжить");
    private static Button iframePayButton = new Button(By.xpath("//button[@class='colored disabled']"),
            "Кнопка оплатить на панели iFrame");
    private static Button cookieOkButton = new Button(By.xpath("//button[@id='cookie-agree']"),
            "Кнопка принятия куки");

    public MtsMainPage() {
        super(mtsOnlinePayLabel, mtsMainPage);
    }

    public void clickCookiesButton() {
        cookieOkButton.waitDisplayedAndClick();
    }

    public void chooseCommunicationServiceCategory() {
        categoryPaymentList.waitAndClick();
        communicationServiceCategory.waitAndClick();
    }

    public void chooseHomeInternetCategory() {
        categoryPaymentList.waitAndClick();
        homeInternetCategory.waitAndClick();
    }

    public void chooseCreditCategory() {
        categoryPaymentList.waitAndClick();
        creditCategory.waitAndClick();
    }

    public void chooseDebtCategory() {
        categoryPaymentList.waitAndClick();
        debtCategory.waitAndClick();
    }

    public String getPhoneNumberLabelText(String attribute) {
        return phoneNumberLabel.getAttribute(attribute);
    }

    public String getDepositAmountLabelText(String attribute) {
        return depositAmountLabel.getAttribute(attribute);
    }

    public String getDepositAmountCreditLabelText(String attribute) {
        return depositAmountCreditLabel.getAttribute(attribute);
    }

    public String getDepositAmountDebtLabelText(String attribute) {
        return depositAmountDebtLabel.getAttribute(attribute);
    }

    public String getEmailLabelText(String attribute) {
        return emailAdressLabel.getAttribute(attribute);
    }

    public String getEmailCreditLabelText(String attribute) {
        return emailAdressCreditLabel.getAttribute(attribute);
    }

    public String getEmailDebtLabelText(String attribute) {
        return emailAdressDebtLabel.getAttribute(attribute);
    }

    public String getSubscriberPhoneText(String attribute) {
        return subscriberPhoneLabel.getAttribute(attribute);
    }

    public String getSubscriberCreditText(String attribute) {
        return subscriberCreditLabel.getAttribute(attribute);
    }

    public String getSubDebtText(String attribute) {
        return subDebtLabel.getAttribute(attribute);
    }

    public void makeOrderForFillTheBalance(String phoneNumber, String moneyAmount) {
        phoneField.sendText(phoneNumber);
        depositAmount.sendText(moneyAmount);
        continueButton.waitAndClick();
    }

    public void switchToFrame() {
        switchToFrameByFrameIndexAndWait(frameIndex);
    }

    public String getTextCreditCardNumber() {
        return iframeCardNumber.getTextFrom();
    }

    public String getTextCardDate() {
        return iframeCardDate.getTextFrom();
    }

    public String getTextCvcCode() {
        return iframeCvcCard.getTextFrom();
    }

    public String getCardOwnerName() {
        return iframeCardHolderName.getTextFrom();
    }

    public boolean arePaymentsIconsDisplayed() {
        return iframePaymentsMethod.isDisplayed();
    }

    public String getMoneyAmountText() {
        String abc = moneyCapacityIframeLabel.getTextFrom();
        return abc.replaceAll("[^0-9.]", "");
    }

    public String getNumberIframeText() {
        String abc = clientNumberIframeLabel.getTextFrom();
        return abc.replaceAll("[^0-9.]", "");
    }

    public String getMoneyFromButton() {
        String abc = iframePayButton.getTextFrom();
        return abc.replaceAll("[^0-9.]", "");
    }
}