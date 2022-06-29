package timvroom;

import config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

public class PlaygroundTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = SeleniumConfig.getWebDriver();
        driver.manage().window().maximize();
        driver.get("http://timvroom.com/selenium/playground/");

        WebElement titleElement = driver.findElement(By.id("tophead"));
        String titleText = titleElement.getText();
        System.out.println(titleText);
        Thread.sleep(1000);

        WebElement answerSlot1 = driver.findElement(By.xpath("//input[@id='answer1']"));
        answerSlot1.sendKeys(titleText);
        Thread.sleep(1000);

        WebElement nameTextField = driver.findElement(By.xpath("//input[@id='name']"));
        nameTextField.sendKeys("Kilgore Trout");
        Thread.sleep(1000);

        WebElement occupationDropdown = driver.findElement(By.xpath("//select[@id='occupation']"));
        Select slc = new Select(occupationDropdown);
        slc.selectByIndex(2);
        Thread.sleep(1000);

        int blueboxCount = driver.findElements(By.className("bluebox")).size();
        WebElement answerSlot4 = driver.findElement(By.xpath("//input[@id='answer4']"));
        answerSlot4.sendKeys(Integer.toString(blueboxCount));
        Thread.sleep(1000);

        WebElement clickMeButton = driver.findElement(By.xpath("//a[contains(text(),'click me')]"));

    }
}
