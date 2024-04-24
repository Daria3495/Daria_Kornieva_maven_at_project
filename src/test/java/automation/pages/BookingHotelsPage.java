package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingHotelsPage {

    WebDriver driver = Driver.getWebDriver();
    public static final String SIX_REVIEW_SCORE_XPATH = "//div[@data-filters-item='review_score:review_score=60']/*[@id=':r1g:']";

    public static final String NINE_REVIEW_SCORE_XPATH = "//div[@data-filters-item='review_score:review_score=90']/*[@id=':r1d:']";
    public static final String SORTING_DROPDOWN_XPATH = "//button[@data-testid='sorters-dropdown-trigger']";
    public static final String FROM_HIGH_TO_LOW_SORTING_OPTION_XPATH = "//span[contains(.,'Property rating (low to high)')]";
    public static final String REVIEW_SCORE_CARD_XPATH = "(//div[@data-testid='property-card-container']//div[@data-testid='review-score'])[1]";
    public static final String HOTEL_CARD_XPATH = "(//div[@data-testid='property-card-container'])[1]";

    public int getScore() {
        return score;
    }

    private int score;

    public void chooseSixHotelReviewScore() {
        driver.findElement(By.xpath(SIX_REVIEW_SCORE_XPATH)).click();
    }

    public void chooseNineHotelReviewScore() {
        driver.findElement(By.xpath(NINE_REVIEW_SCORE_XPATH)).click();
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
}
