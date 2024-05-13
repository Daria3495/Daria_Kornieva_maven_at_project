package automation.pages;

import automation.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoogleMainPage {

    private static final Logger LOGGER = LogManager.getLogger(GoogleMainPage.class);
    public static final String COOKIES_REJECT_BUTTON_XPATH = "//button[contains(.,'Reject')]";
    public static final String SEARCH_FIELD_XPATH = "//textarea[@title='Search']";
    WebDriver driver = Driver.getWebDriver();
    public void openMainPage() {
        driver.get("https://www.google.com/?hl=en");
        LOGGER.info("No redirection to Google main page");
        driver.findElement(By.xpath(COOKIES_REJECT_BUTTON_XPATH)).click();
        LOGGER.info("Cookies are not declined");
    }

    public void chooseSearchField() {
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).click();
        LOGGER.info("Search field is not chosen");
    }

    public void pasteTitleText() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.COMMAND);
        LOGGER.info("Command button is not chosen down on keyboard");
        action.sendKeys("v").clickAndHold();
        LOGGER.info("'V' button is not chosen and hold on keyboard");
        action.keyUp(Keys.COMMAND);
        LOGGER.info("Command button is not chosen up on keyboard");
        action.build().perform();
    }

    public void enterKeyboard() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
        LOGGER.info("Enter button is not chosen on keyboard");
    }
}
