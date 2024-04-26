package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoogleMainPage {
    public static final String COOKIES_REJECT_BUTTON_XPATH = "//button[contains(.,'Reject')]";
    public static final String SEARCH_FIELD_XPATH = "//textarea[@title='Search']";
    WebDriver driver = Driver.getWebDriver();
    public void openMainPage() {
        driver.get("https://www.google.com/?hl=en");
        driver.findElement(By.xpath(COOKIES_REJECT_BUTTON_XPATH)).click();
    }

    public void chooseSearchField() {
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).click();
    }

    public void pasteTitleText() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.COMMAND);
        action.sendKeys("v").clickAndHold();
        action.keyUp(Keys.COMMAND);
        action.build().perform();
    }

    public void enterKeyboard() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
    }
}
