package framework.base;

import io.qameta.allure.Step;

public class BasePage {

    private BaseElement baseElement;
    private String name;

    public BasePage() {
    }

    public BasePage(BaseElement baseElement, String name) {
        this.baseElement = baseElement;
        this.name = name;
    }
    @Step("Проверить, что находимся на главной странице сайта МТС")
    public boolean isOnPage() {
        return baseElement.isDisplayed();
    }
}