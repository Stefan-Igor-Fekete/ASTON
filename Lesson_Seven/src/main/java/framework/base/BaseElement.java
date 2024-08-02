package framework.base;

import framework.DriverStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseElement {
    Duration WAIT_TIME = Duration.ofSeconds(10);
    static DriverStart driverStart = DriverStart.getInstance();

    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        return findElement() != null;
    }

    protected WebElement findElement() {
        waitElementDisplayed();
        return driverStart.getDriver().findElement(locator);
    }

    public void waitAndClick() {
        waitElementClicked().click();
    }

    public void waitDisplayedAndClick() {
        waitElementDisplayed().click();
    }

    public String getAttribute(String attribute) {
        return findElement().getAttribute(attribute);
    }

    protected WebElement waitElementDisplayed() {
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitElementClicked() {
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public  List<WebElement> findElements(WebElement element) {
        return driverStart.getDriver().findElements((By) element);
    }

    public WebElement findElement(By xpath) {
        return driverStart.getDriver().findElement(xpath);
    }

    public String getTextFrom() {
        return findElement().getText();
    }

    public String getTextFromError() {
        WebElement activeElement = driverStart.getDriver().switchTo().activeElement();
        return activeElement.getAttribute("validationMessage");
    }
}
