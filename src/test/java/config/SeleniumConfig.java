package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumConfig {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getWebDriver(){
        if (driver==null) {
            System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }

    public static WebDriverWait getWebDriverWait() {
        if (wait==null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        return wait;
    }
}
