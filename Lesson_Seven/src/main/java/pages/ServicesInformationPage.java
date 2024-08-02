package pages;

import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ServicesInformationPage extends BasePage {
    private static Label servicesImformationLabel = new Label(By.xpath("//span[@class='breadcrumbs__link']"),
            "Лейбл страницы сервисов");
    private static Button mainPageButton = new Button(By.xpath("//span[contains(text(), 'Главная')]"),
            "Кнопка главного меню");

    public String getServiceLabelText() {
        return servicesImformationLabel.getTextFrom();
    }

    public void clickMainPageButton() {
        mainPageButton.waitAndClick();
    }
}