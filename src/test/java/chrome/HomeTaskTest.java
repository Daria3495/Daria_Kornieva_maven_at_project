package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeTaskTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/?hl=en");
        waitForElementPresentsAndClick(driver, By.xpath("//button[contains(.,'Reject')]"));
        WebElement searchField = driver.findElement(By.xpath("//textarea[@title='Search']"));
        searchField.click();
        searchField.sendKeys("погода минск");
        searchField.submit();
        waitForElementPresentsAndClick(driver, By.cssSelector("[data-wob-di='1']"));
        waitForElementPresentsAndClick(driver, By.xpath("(//span[contains(.,'13:00')])[2]"));
        System.out.println(driver.findElement(By.xpath("//span[@id='wob_tm']")));
        driver.quit();
    }

    private static void waitForElementPresentsAndClick(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(selector)).click();
    }
}
