package automation.pages;

import automation.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSeparateHotelPage {

    WebDriver driver = Driver.getWebDriver();
    public static final String REVIEW_SCORE_COMPONENT_XPATH = "//div[@data-testid='review-score-component']";

    public void findHotelReviewScore() {
        String scoreText = driver.findElement(By.xpath(REVIEW_SCORE_COMPONENT_XPATH)).getText();
        int score = Integer.parseInt(scoreText.substring(0, scoreText.indexOf('.')));
        Assert.assertEquals("Hotel score is less than 6", true, score > 9);
    }

}
