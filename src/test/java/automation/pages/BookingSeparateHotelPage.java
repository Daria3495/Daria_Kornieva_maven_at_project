package automation.pages;

import automation.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class BookingSeparateHotelPage {

    public double getScore() {
        return score;
    }
    private double score;

    WebDriver driver = Driver.getWebDriver();

    private static final Logger LOGGER = LogManager.getLogger(BookingSeparateHotelPage.class);
    public static final String REVIEW_SCORE_COMPONENT_XPATH = "//div[@data-testid='review-score-component']";

    public void switchToAnotherTab() {

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        LOGGER.info("New tab is not opened");
    }

    public double findHotelReviewScore() {
        String scoreText = driver.findElement(By.xpath(REVIEW_SCORE_COMPONENT_XPATH)).getText();
        score = Double.parseDouble(scoreText.substring(0, scoreText.indexOf('\n')));
        LOGGER.info("Hotel review score {} is not found", score);
        return score;
    }

}
