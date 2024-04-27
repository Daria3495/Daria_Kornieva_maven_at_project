package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BookingHotelsPage {
    WebDriver driver = Driver.getWebDriver();
    public static final String HOTEL_CARD_IN_THE_LIST_XPATH = "(//div[@data-testid='property-card-container'])[%s]";
    public static final String REVIEW_SCORE_XPATH = "//input[contains(@aria-label,' %s+:')]";
    public static final String SELECTED_REVIEW_TAB_XPATH = "//div[@class='a1d43fa1ac']/div/label/span";
    public static final String SORTING_DROPDOWN_XPATH = "//button[@data-testid='sorters-dropdown-trigger']";
    public static final String FROM_HIGH_TO_LOW_SORTING_OPTION_XPATH = "//span[contains(.,'Property rating (low to high)')]";
    public static final String REVIEW_SCORE_CARD_XPATH = "(//div[@data-testid='property-card-container']//div[@data-testid='review-score'])[1]";
    public static final String HOTEL_CARD_XPATH = "(//div[@data-testid='property-card-container'])[1]";
    private WebElement hotelInTheList;
    public int getScore() {
        return score;
    }
    private int score;

    public void chooseHotelReviewScore(int reviewNumber) {
        String dynamicXpath = String.format(REVIEW_SCORE_XPATH, reviewNumber);
        driver.findElement(By.xpath(dynamicXpath)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECTED_REVIEW_TAB_XPATH)));
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

    public int findHotelReviewScore() {
        String scoreText = driver.findElement(By.xpath(REVIEW_SCORE_CARD_XPATH)).getText();
        score = scoreText.indexOf('.');
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
}
