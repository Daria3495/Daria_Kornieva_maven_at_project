package jUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class ChangeElementColor {
    WebDriver driver = new ChromeDriver();

    @Before
    public void preCondition() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://booking.com");
        driver.findElement(By.id("onetrust-reject-all-handler")).click();
        //TODO deal with try/catch
        if (driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        }
    }

    @Test
    public void changingColorForElement() {
        driver.findElement(By.xpath("//input[@aria-label='Where are you going?']"))
                .sendKeys("London");
        driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
        WebElement tenthHotel = driver.findElement(By.xpath("(//div[@data-testid='property-card-container'])[10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenthHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenthHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", tenthHotel);
        byte[] hotelScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(Paths.get("hotelScreen.png"), hotelScreen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
