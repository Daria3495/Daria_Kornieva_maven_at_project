package jUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class TutorialTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void redirectionToTutorial() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.id("accept-choices")).click();
    }


    @Test
    public void interactionWithElementsWithKeyboard() {
        WebElement title = driver.findElement(By.xpath("//div[@id='main']/h1/span[contains(text(), 'Tutorial')]"));

        Actions action = new Actions(driver);
        action.doubleClick(title);
        action.keyDown(Keys.COMMAND);
        action.sendKeys("c").clickAndHold();
        action.keyUp(Keys.COMMAND);
        action.build().perform();

        driver.get("https://www.google.com/?hl=en");
        driver.findElement(By.xpath("//button[contains(.,'Reject')]")).click();
        WebElement searchField = driver.findElement(By.xpath("//textarea[@title='Search']"));
        searchField.click();
        action.keyDown(Keys.COMMAND);
        action.sendKeys("v").clickAndHold();
        action.keyUp(Keys.COMMAND);
        action.build().perform();
        action.sendKeys(Keys.ENTER);

    }
}
