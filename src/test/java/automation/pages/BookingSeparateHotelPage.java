package automation.pages;

import automation.driver.Driver;
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
    public static final String REVIEW_SCORE_COMPONENT_XPATH = "//div[@data-testid='review-score-component']";

    public void switchToAnotherTab() {

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public double findHotelReviewScore() {
        String scoreText = driver.findElement(By.xpath(REVIEW_SCORE_COMPONENT_XPATH)).getText();
        score = Double.parseDouble(scoreText.substring(0, scoreText.indexOf('\n')));
        return score;
    }

}
