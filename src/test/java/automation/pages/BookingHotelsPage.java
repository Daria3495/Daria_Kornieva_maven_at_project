package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingHotelsPage {
    WebDriver driver = Driver.getWebDriver();
    public static final String HOTEL_CARD_IN_THE_LIST_XPATH = "(//div[@data-testid='property-card-container'])[%s]";
    public static final String REVIEW_SCORE_XPATH = "//input[contains(@aria-label,' %s+:')]";
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
    }

    public void openSortingDropDown() {
        driver.findElement(By.xpath(SORTING_DROPDOWN_XPATH)).click();
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

//    public void highlightHotelCard(String backgroundColor, String textColor) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '%s'", backgroundColor, hotelInTheList);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = '%s'", textColor, hotelInTheList);
//    }

    public void highlightHotelCard() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotelInTheList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", hotelInTheList);
    }
}
