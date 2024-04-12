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
        waitForElementPresents(driver, By.xpath("//button[contains(.,'Reject')]")).click();
        WebElement searchField = driver.findElement(By.xpath("//textarea[@title='Search']"));
        searchField.click();
        searchField.sendKeys("погода минск");
        searchField.submit();
        waitForElementPresents(driver, By.cssSelector("[data-wob-di='1']")).click();
        String dayOfWeek = driver.findElement(By.cssSelector("[role=heading] > #wob_dts")).getText();
        WebElement dayElement = waitForElementPresents(driver,
                By.cssSelector("text[aria-label $= \"Celsius " + dayOfWeek + " 12:00\"]"));
        String ariaLabelValue = dayElement.getAttribute("aria-label");
        System.out.println(ariaLabelValue.substring(0, ariaLabelValue.indexOf("Celsius")));
        driver.quit();
    }

    private static WebElement waitForElementPresents(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }
}
