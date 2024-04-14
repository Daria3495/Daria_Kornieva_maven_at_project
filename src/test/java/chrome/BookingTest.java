package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;

public class BookingTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://booking.com");
        driver.findElement(By.id("onetrust-reject-all-handler")).click();

        //TODO deal with try/catch
        if (driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        }
        driver.findElement(By.xpath("//input[@aria-label='Where are you going?']"))
                .sendKeys("Paris");
        driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"))
                .click();
        //TODO deal with dates
        driver.findElement(By.xpath("//span[@data-date='2024-04-17']")).click();
        driver.findElement(By.xpath("//span[@data-date='2024-04-24']")).click();
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

        WebElement hotelScore = driver.findElement(By.xpath("(//div[@data-testid='property-card-container']//div[@data-testid='review-score'])[1]"));
        String score = hotelScore.getText();
        int score1 = Integer.parseInt(score.substring(0, score.indexOf('.')));
        if (score1 >= 6) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed, rating is less than expected");
        }
        driver.quit();

        //String inThreeDays = String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(3)
        //       .getDayOfMonth());
    }

}
