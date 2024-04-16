package jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.NoSuchElementException;

public class ParisBookingXpathTest {
//    private final static String SIX_SCORE_RAITING_CHECKBOX = "//div[contains(@id, 'filter_group_review_score_:r')]/div[10]";
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
    public void findPaisHotelScore() throws InterruptedException {
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

        driver.findElement(By.xpath
                ("//div[@data-filters-item='review_score:review_score=60']//span[2]")).click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewScore);
        //"(//div[@data-filters-item='review_score:review_score=60']/*[contains(.,'Pleasant: 6+')])[1]"
        //"(//div[@data-filters-item='review_score:review_score=60']/*[@id=':r1g:']"
        // *[@id=":r1g:"]
        //input[contains(@aria-label,'Pleasant: 6+:')]
        ////div[@data-filters-item='review_score:review_score=60']/*[@id=':r1g:']"
//        reviewScore.click();

        WebElement sort = driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sort);
        sort.click();
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


//        WebElement sixScoreRaitingCheckbox = driver.findElement(By.xpath(SIX_SCORE_RAITING_CHECKBOX));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sixScoreRaitingCheckbox);
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//            new WebDriverWait(driver, Duration.ofSeconds(5)).until(
//                    ExpectedConditions.visibilityOfElementLocated(By.xpath(SIX_SCORE_RAITING_CHECKBOX))
//            ).click();
//            new WebDriverWait(driver, Duration.ofSeconds(5)).until(
//                    ExpectedConditions.elementToBeSelected(By.xpath(SIX_SCORE_RAITING_CHECKBOX))
//            );
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        } catch (TimeoutException e) {
//            System.out.println("Something went wrong.");
//        }

//        WebElement el = driver.findElement(By.xpath("//div[contains(@id, 'filter_group_review_score_:r')]/div[10]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//            new WebDriverWait(driver, Duration.ofSeconds(5)).until(
//                    ExpectedConditions.visibilityOf(el)
//            ).click();
//            new WebDriverWait(driver, Duration.ofSeconds(5)).until(
//                    ExpectedConditions.elementToBeSelected(el)
//            );
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        } catch (TimeoutException e) {
//            System.out.println("Something went wrong.");
//        }
