package framework.base;

import framework.DriverStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseElement {
    Actions action = new Actions(driverStart.getDriver());
    static Duration WAIT_TIME = Duration.ofSeconds(10);
    static DriverStart driverStart = DriverStart.getInstance();

    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement findElement() {
        waitElementDisplayed();
        return driverStart.getDriver().findElement(locator);
    }

    public String getAttribute(String attribute) {
        return findElement().getAttribute(attribute);
    }

    protected WebElement waitElementDisplayed() {
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitElementClicked() {
        WebDriverWait waiter = new WebDriverWait(driverStart.getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isDisplayed() {
        return findElement() != null;
    }

    public void waitAndClick() {
        waitElementClicked().click();
    }

    public void waitDisplayedAndClick() {
        waitElementDisplayed().click();
    }

    public List<WebElement> findElements(WebElement element) {
        return driverStart.getDriver().findElements((By) element);
    }

    public WebElement findElement(By xpath) {
        return driverStart.getDriver().findElement(xpath);
    }

    public String getTextFrom() {
        return findElement().getText();
    }

    public String getTextFromActiveElement() {
        WebElement activeElement = driverStart.getDriver().switchTo().activeElement();
        return activeElement.getAttribute("validationMessage");
    }

    public void hoverElement() {
        action.moveToElement(findElement()).perform();
    }

    public static void switchToFrameByFrameIndex(int index) {
        driverStart.getDriver().switchTo().frame(index);
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
