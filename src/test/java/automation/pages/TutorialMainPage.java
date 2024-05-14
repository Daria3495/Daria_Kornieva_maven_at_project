package automation.pages;

import automation.driver.Driver;
import automation.utils.KeyboardAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TutorialMainPage {

    private static final Logger LOGGER = LogManager.getLogger(TutorialMainPage.class);
    public static final String TUTORIAL_TITLE_XPATH = "//div[@id='main']/h1/span[contains(text(), 'Tutorial')]";
    WebDriver driver = Driver.getWebDriver();

    public void openTutorialPage() {
        driver.get("https://www.w3schools.com/java/");
        LOGGER.info("Redirection to Google main page");
        driver.findElement(By.id("accept-choices")).click();
        LOGGER.info("Cookies are allowed");
    }

    public void copyTitleText() {
        WebElement title = driver.findElement(By.xpath(TUTORIAL_TITLE_XPATH));

//        KeyboardAction.copyText(title);
        Actions action = new Actions(driver);
        action.doubleClick(title);
        LOGGER.info("Title is highlighted by double click");
        action.keyDown(Keys.COMMAND);
        LOGGER.info("Command button is chosen down on keyboard");
        action.sendKeys("c").clickAndHold();
        LOGGER.info("'C' button is chosen and hold on keyboard");
        action.keyUp(Keys.COMMAND);
        LOGGER.info("Command button is chosen up on keyboard");
        action.build().perform();
    }


}
