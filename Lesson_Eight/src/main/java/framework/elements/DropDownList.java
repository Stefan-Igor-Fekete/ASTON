package framework.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class DropDownList extends BaseElement {
    public DropDownList(By locator, String name) {
        super(locator, name);
    }
}