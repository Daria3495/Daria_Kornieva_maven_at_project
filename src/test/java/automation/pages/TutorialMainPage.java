package automation.pages;

import automation.driver.Driver;
import automation.utils.KeyboardAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TutorialMainPage {

    public static final String TUTORIAL_TITLE_XPATH = "//div[@id='main']/h1/span[contains(text(), 'Tutorial')]";
    WebDriver driver = Driver.getWebDriver();

    public void openTutorialPage() {
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.id("accept-choices")).click();
    }

    public void copyTitleText() {
        WebElement title = driver.findElement(By.xpath(TUTORIAL_TITLE_XPATH));

//        KeyboardAction.copyText(title);
        Actions action = new Actions(driver);
        action.doubleClick(title);
        action.keyDown(Keys.COMMAND);
        action.sendKeys("c").clickAndHold();
        action.keyUp(Keys.COMMAND);
        action.build().perform();
    }


}
