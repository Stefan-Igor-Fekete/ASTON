package framework.base;

import framework.DriverStart;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseElement {
    static Duration WAIT_TIME = Duration.ofSeconds(10);
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

    protected WebElement waitElementDisplayed() {
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitElementClicked() {
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getTextFrom() {
        return findElement().getText();
    }

    public static void switchToFrameByFrameIndexAndWait(int index) {
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        waiter.until(driver -> {
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            return iframes.size() > index ? iframes.get(index) : null;
        });
        driverStart.getDriver().switchTo().frame(index);
    }
}