package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class TextField extends BaseElement {

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        findElement().sendKeys(text);
    }
}