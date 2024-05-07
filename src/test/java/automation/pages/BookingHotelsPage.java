package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BookingHotelsPage {
    WebDriver driver = Driver.getWebDriver();
    public static final String HOTEL_CARD_IN_THE_LIST_XPATH = "(//div[@data-testid='property-card-container'])[%s]";
    public static final String REVIEW_SCORE_XPATH = "//input[contains(@aria-label,' %s+:')]";
    public static final String SELECTED_REVIEW_TAB_CSS = "[data-testid='filter:review_score=%s0']";
    public static final String SORTING_DROPDOWN_XPATH = "//button[@data-testid='sorters-dropdown-trigger']";
    public static final String FROM_HIGH_TO_LOW_SORTING_OPTION_XPATH = "//span[contains(.,'Property rating (low to high)')]";
    public static final String REVIEW_SCORE_CARD_XPATH = "(//div[@data-testid='property-card-container']//div[@data-testid='review-score'])[1]";
    public static final String HOTEL_CARD_XPATH = "(//div[@data-testid='property-card-container'])[1]";
    public static final String FAVOURITE_ICON_XPATH ="(//button[@data-testid='wishlist-button'])[74]";
    public static final String FOOTER_PART_XPATH = "newsletter_button_footer";
    private WebElement hotelInTheList;
    public double getScore() {
        return score;
    }
    private double score;

    public void chooseHotelReviewScore(int reviewNumber) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String dynamicXpath = String.format(REVIEW_SCORE_XPATH, reviewNumber);
        driver.findElement(By.xpath(dynamicXpath)).click();
        try {
            FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(String.format(SELECTED_REVIEW_TAB_CSS, reviewNumber))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void openSortingDropDown() {
        WebElement sort = driver.findElement(By.xpath(SORTING_DROPDOWN_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",sort);
        sort.click();
    }

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",sort);
//        sort.click(); если не получится, переделать этот

    public void chooseSortingOption() {
        driver.findElement(By.xpath(FROM_HIGH_TO_LOW_SORTING_OPTION_XPATH)).click();
    }

    public double findHotelReviewScore() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String scoreText = driver.findElement(By.xpath(REVIEW_SCORE_CARD_XPATH)).getText();
        score = Double.parseDouble(scoreText.substring(0, scoreText.indexOf('\n')));
        return score;
    }

    public void chooseHotelFromTheList() {
        driver.findElement(By.xpath(HOTEL_CARD_XPATH)).click();
    }

    public void findHotelInTheList(int hotelNumber) {
        hotelInTheList = driver.findElement(By.xpath(String.format(HOTEL_CARD_IN_THE_LIST_XPATH, hotelNumber)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotelInTheList);
    }

    public void highlightHotelCard() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotelInTheList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", hotelInTheList);
    }
// TODO не работает скрол
    public void chooseFavouriteIcon() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        new WebDriverWait(driver, Duration.ofSeconds(20))
//                .until(drv -> drv.findElement(By.xpath(FAVOURITE_ICON_XPATH))).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement favouriteIcon = driver.findElement(By.xpath(FAVOURITE_ICON_XPATH));
        WebElement footer = driver.findElement(By.id(FOOTER_PART_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",footer);
        favouriteIcon.click();

    }
}
