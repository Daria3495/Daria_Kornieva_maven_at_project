package jUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.NoSuchElementException;

public class PragueBookingXpathTest {

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
    public void findPragueFirstHotel() {
        driver.findElement(By.xpath("//input[@aria-label='Where are you going?']"))
                .sendKeys("Prague");

        driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"))
                .click();
        String startTravelDate = String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(1));
        String endTravelDate = String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(8));
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']",startTravelDate))).click();
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", endTravelDate))).click();
        driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();

        WebElement reviewScore = driver.findElement(By.xpath("//div[@data-filters-item='review_score:review_score=90']/*[@id=':r2h:']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewScore);
        reviewScore.click();
        driver.findElement(By.xpath("(//div[@data-testid='property-card-container'])[1]//div[@data-testid='title']"))
                .click();
        WebElement hotelScore = driver.findElement(By.xpath("//div[@data-testid='review-score-component']"));
        String scoreText = hotelScore.getText();
        int score = Integer.parseInt(scoreText.substring(0, scoreText.indexOf('.')));
        if (score >= 9) {
            System.out.println("Correct hotel was chosen");
        } else {
            System.out.println("Test failed, rating is less than expected");
        }
        driver.quit();


    }

}
