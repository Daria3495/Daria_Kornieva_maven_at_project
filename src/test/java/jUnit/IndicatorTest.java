package jUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.NoSuchElementException;

public class IndicatorTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void preConditionRedirectionToBooking() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://booking.com");
        driver.findElement(By.id("onetrust-reject-all-handler")).click();

        try {
            WebElement signInAlert = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
            if (signInAlert.isDisplayed()) {
                signInAlert.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Sign in alert was not displayed");
        }
    }

    @Test
    public void findAndCheckCurrencyViewHint() {

        WebElement currencyIcon = driver.findElement(
                By.xpath("//button[@data-testid='header-language-picker-trigger']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyIcon);
        actions.build().perform();
        System.out.println(currencyIcon.getText());
//        driver.quit();
    }


}
