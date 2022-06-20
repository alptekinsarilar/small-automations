package timvroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PlaygroundTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://timvroom.com/selenium/playground/");

        WebElement titleElement = driver.findElement(By.id("tophead"));
        String titleText = titleElement.getText();
        System.out.println(titleText);
        Thread.sleep(2000);

        WebElement answerSlot1 = driver.findElement(By.xpath("//input[@id='answer1']"));
        answerSlot1.sendKeys(titleText);
        Thread.sleep(2000);

        WebElement nameTextField = driver.findElement(By.xpath("//input[@id='name']"));
        nameTextField.sendKeys("Kilgore Trout");
        Thread.sleep(2000);

        WebElement occupationDropdown = driver.findElement(By.xpath("//select[@id='occupation']"));
        Select slc = new Select(occupationDropdown);
        slc.selectByIndex(2);
        Thread.sleep(2000);

        int blueboxCount = driver.findElements(By.className("bluebox")).size();
        WebElement answerSlot4 = driver.findElement(By.xpath("//input[@id='answer4']"));
        answerSlot4.sendKeys(Integer.toString(blueboxCount));
        Thread.sleep(2000);












        driver.close();
    }
}
