package framework.base;

import framework.DriverStart;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseElement {
    static Duration WAIT_TIME = Duration.ofSeconds(4);

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
        return DriverStart.getInstance().getDriver().findElement(locator);
    }

    public void waitAndClick() {
        waitElementClicked().click();
    }

    public void waitDisplayedAndClick() {
        waitElementDisplayed().click();
    }

    public String getAttribute(String attribute) {
        waitElementDisplayed();
        return findElement().getAttribute(attribute);
    }

    protected WebElement waitElementDisplayed() {
        WebDriverWait waiter = new WebDriverWait(DriverStart.getInstance().getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitElementClicked() {
        WebDriverWait waiter = new WebDriverWait(DriverStart.getInstance().getDriver(), WAIT_TIME);
        return waiter.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getTextFrom() {
        waitElementDisplayed();
        return findElement().getText();
    }

    public static void switchToFrameByFrameIndexAndWait(int index) {
        WebDriverWait waiter = new WebDriverWait(DriverStart.getInstance().getDriver(), WAIT_TIME);
        try {
            // Ожидание, пока фрейм с нужным индексом станет доступен
            WebElement frame = waiter.until(driver -> {
                List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
                if (iframes.size() > index) {
                    return iframes.get(index);
                } else {
                    return null; // Если индекс выходит за границы списка фреймов
                }
            });

            if (frame != null) {
                // Переключение на фрейм, если он найден
                DriverStart.getInstance().getDriver().switchTo().frame(frame);
                System.out.println("Успешно переключено на фрейм с индексом: " + index);
            } else {
                // Обработка случая, когда фрейм с указанным индексом не найден
                throw new NoSuchFrameException("Фрейм с индексом " + index + " не найден.");
            }
        } catch (TimeoutException e) {
            System.out.println("Истекло время ожидания для фрейма с индексом " + index);
        } catch (NoSuchFrameException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка при переключении на фрейм: " + e.getMessage());
        }
    }
}