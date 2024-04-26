package automation.pages;

import automation.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSeparateHotelPage {

    public int getScore() {
        return score;
    }
    private int score;

    WebDriver driver = Driver.getWebDriver();
    public static final String REVIEW_SCORE_COMPONENT_XPATH = "//div[@data-testid='review-score-component']";

    public int findHotelReviewScore() {
        String scoreText = driver.findElement(By.xpath(REVIEW_SCORE_COMPONENT_XPATH)).getText();
        score = scoreText.indexOf('.');
        return score;
    }

}
