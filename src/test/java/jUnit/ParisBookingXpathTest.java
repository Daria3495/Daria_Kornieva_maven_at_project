package jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.NoSuchElementException;

public class ParisBookingXpathTest {

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
    public void findPaisHotelScore() {
        driver.findElement(By.xpath("//input[@aria-label='Where are you going?']"))
                .sendKeys("Paris");
        driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"))
                .click();
        String startTravelDate = String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(3));
        String endTravelDate = String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(10));
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']",startTravelDate))).click();
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", endTravelDate))).click();


        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
        WebElement adultPlusButton = driver.findElement
                (By.xpath("//input[@id='group_adults']/./following-sibling::div/button[2]"));
        adultPlusButton.click();
        adultPlusButton.click();
        driver.findElement(By.xpath("//input[@id='no_rooms']/./following-sibling::div/button[2]"))
                .click();
        driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
        driver.findElement(By.xpath("//div[@data-filters-item='review_score:review_score=60']/*[@id=':r1g:']"))
                .click();
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//span[contains(.,'Property rating (low to high)')]")).click();
    }

    @After
    public void reCheckCorrectnessOfScore() {
        WebElement hotelScore = driver.findElement(By.xpath("(//div[@data-testid='property-card-container']//div[@data-testid='review-score'])[1]"));
        String scoreText = hotelScore.getText();
        int score = Integer.parseInt(scoreText.substring(0, scoreText.indexOf('.')));
        if (score >= 6) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed, rating is less than expected");
        }
        driver.quit();
    }
}
