package pages;

import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.DropDownList;
import framework.elements.Label;
import framework.elements.TextField;
import framework.enums.MtsPaymentCategory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static framework.base.BaseElement.switchToFrameByFrameIndexAndWait;

public class MtsMainPage extends BasePage {
    private static String mtsMainPage = "Главная страница МТС";
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
    private static Label depositAmountLabel = new Label(By.xpath("//div[@class='pay__form']//input[@class='total_rub']"),
            "Текст внутри поля: Сумма");
    private static Label depositAmountHomeInternetLabel = new Label(By.xpath("//input[@id='internet-sum']"),
            "Check");
    private static Label depositAmountDebtLabel = new Label(By.xpath("//input[@id='arrears-sum']"),
            "Текст внутри поля: Сумма");
    private static Label emailAdressDebtLabel = new Label(By.xpath("//div[@class='pay__form']//input[@id='arrears-email']"),
            "Текст внутри поля: E-mail для отправки чека");
    private static Label emailAdressLabel = new Label(By.xpath("//div[@class='pay__form']//input[@id='internet-email']"),
            "Текст внутри поля: E-mail для отправки чека");
    private static Label emailAdressServiceLabel = new Label(By.xpath("//div[@class='pay__form']//input[@id='connection-email']"),
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
    private static Label iframeCardHolderName = new Label(By.xpath("//div[@class='content ng-tns-c46-3']"),
            "Текст внутри поля iFrame: Имя держателя (как на карте)");
    private static Label visaPaymentLabel = new Label(By.xpath("(//img[@class='ng-tns-c61-0 ng-star-inserted'])[1]"),
            "Visa платёжный лейбл");
    private static Label masterCardPaymentLabel = new Label(By.xpath("(//img[@class='ng-tns-c61-0 ng-star-inserted'])[2]"),
            "MasterCard платёжный лейбл");
    private static Label masterCardAndMirPaymentLabel = new Label(By.xpath("//img[@class='ng-tns-c61-0 ng-trigger ng-trigger-randomCardState ng-star-inserted']"),
            "MasterCard/Mir  платёжный лейбл");
    private static Label belCardPaymentLabel = new Label(By.xpath("(//img[@class='ng-tns-c61-0 ng-star-inserted'])[3]"),
            "Bel card  платёжный лейбл");
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
    @Step("Нажать на кнопку принятие Cookie")
    public void clickCookiesButton() {
        try {
            cookieOkButton.waitDisplayedAndClick();
        } catch (NoSuchElementException e) {
            System.out.println("Окно с куками не отображается.");
        } catch (TimeoutException e) {
            System.out.println();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при попытке нажать на кнопку куки: " + e.getMessage());
        }
    }

    @Step("Выбрать категорию 'Услуги связи'")
    public void chooseCommunicationServiceCategory() {
        categoryPaymentList.waitDisplayedAndClick();
        communicationServiceCategory.waitDisplayedAndClick();
    }

    @Step("Получить текст из поля: Номер телефона, в категории: Услуги связи ")
    public String getPhoneNumberLabelText(String attribute) {
        return phoneNumberLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: Сумма для услуги, в категории: Услуги связи")
    public String getDepositAmountServiceLabelText(String attribute) {
        return depositAmountLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: E-mail для услуги, в категории: Услуги связи")
    public String getEmailLabelText(String attribute) {
        return emailAdressServiceLabel.getAttribute(attribute);
    }

    @Step("Выбрать категорию 'Домашний интернет'")
    public void chooseHomeInternetCategory() {
        categoryPaymentList.waitDisplayedAndClick();
        homeInternetCategory.waitDisplayedAndClick();
    }

    @Step("Получить текст из поля: Номер телефона, в категории: Домашний интернет ")
    public String getSubscriberPhoneText(String attribute) {
        return subscriberPhoneLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: Сумма для услуги, в категории: Домашний интернет")
    public String getDepositAmountLabelText(String attribute) {
        return depositAmountHomeInternetLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: E-mail для услуги, в категории: Домашний интернет")
    public String getEmailHomeInternetText(String attribute) {
        return emailAdressLabel.getAttribute(attribute);
    }

    @Step("Выбрать категорию 'Рассрочка'")
    public void chooseCreditCategory() {
        categoryPaymentList.waitDisplayedAndClick();
        creditCategory.waitDisplayedAndClick();
    }

    @Step("Получить текст из поля: Номер договора на 44, в категории: Рассрочка ")
    public String getSubscriberCreditText(String attribute) {
        return subscriberCreditLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: Сумма, в категории: Рассрочка ")
    public String getDepositAmountCreditLabelText(String attribute) {
        return depositAmountCreditLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: E-mail для услуги, в категории: Рассрочка")
    public String getEmailCreditLabelText(String attribute) {
        return emailAdressCreditLabel.getAttribute(attribute);
    }

    @Step("Выбрать категорию 'Задолженность'")
    public void chooseDebtCategory() {
        categoryPaymentList.waitDisplayedAndClick();
        debtCategory.waitDisplayedAndClick();
    }

    @Step("Получить текст из поля: Номер счёта на 2073, в категории: Задолженность ")
    public String getSubDebtText(String attribute) {
        return subDebtLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: Сумма, в категории: Задолженность")
    public String getDepositAmountDebtLabelText(String attribute) {
        return depositAmountDebtLabel.getAttribute(attribute);
    }

    @Step("Получить текст из поля: E-mail для услуги, в категории: Задолженность")
    public String getEmailDebtLabelText(String attribute) {
        return emailAdressDebtLabel.getAttribute(attribute);
    }

    @Step("Заполнить поля в соответствии с выданными реквизитами")
    public void makeOrderForFillTheBalance(String phoneNumber, String moneyAmount) {
        phoneField.sendText(phoneNumber);
        depositAmount.sendText(moneyAmount);
        continueButton.waitAndClick();
    }

    @Step("Перейти на iframe")
    public void switchToFrame(int frameIndex) {
        switchToFrameByFrameIndexAndWait(frameIndex);
    }

    @Step("Получить текст из поля: Номер карты ")
    public String getTextCreditCardNumber() {
        return iframeCardNumber.getTextFrom();
    }

    @Step("Получить текст из поля: Срок действия ")
    public String getTextCardDate() {
        return iframeCardDate.getTextFrom();
    }

    @Step("Получить текст из поля: CVC ")
    public String getTextCvcCode() {
        return iframeCvcCard.getTextFrom();
    }

    @Step("Получить текст из поля: Имя держателя (как на карте) ")
    public String getCardOwnerName() {
        return iframeCardHolderName.getTextFrom();
    }

    @Step("Проверить наличие платёжных логотипов")
    public boolean arePaymentsIconsDisplayed() {
        return belCardPaymentLabel.isDisplayed() && masterCardPaymentLabel.isDisplayed()
                && masterCardAndMirPaymentLabel.isDisplayed() &&
                visaPaymentLabel.isDisplayed();
    }

    @Step("Получить сумму пополнения ")
    public String getMoneyAmountText() {
        String abc = moneyCapacityIframeLabel.getTextFrom();
        return abc.replaceAll("[^0-9.]", "");
    }

    @Step("Получить номер клиента оставившего заявку на пополнение")
    public String getNumberIframeText() {
        String abc = clientNumberIframeLabel.getTextFrom();
        return abc.replaceAll("[^0-9.]", "");
    }

    @Step("Получить сумму пополнения с кнопки: Оплатить")
    public String getMoneyFromButton() {
        String abc = iframePayButton.getTextFrom();
        return abc.replaceAll("[^0-9.]", "");
    }
}