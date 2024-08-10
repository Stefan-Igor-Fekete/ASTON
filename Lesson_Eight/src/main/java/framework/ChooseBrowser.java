package framework;

import framework.enums.ListOfBrowsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChooseBrowser {
    public static WebDriver getBrowser(String browser) {
        WebDriver driver;
        switch (ListOfBrowsers.valueOf(browser)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                try {
                    throw new Exception("No such browser");
                } catch (Exception e) {
                    e.printStackTrace();
                    driver = null;
                }
        }
        return driver;
    }
}