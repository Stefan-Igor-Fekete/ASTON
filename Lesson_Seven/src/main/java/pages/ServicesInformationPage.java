package pages;

import framework.base.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ServicesInformationPage extends BasePage {
    private static Label servicesImformationLabel = new Label(By.xpath("//span[@class='breadcrumbs__link']"),
            "Лейбл страницы сервисов");

    public String getServiceLabelText() {
        return servicesImformationLabel.getTextFrom();
    }
}