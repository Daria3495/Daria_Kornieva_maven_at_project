package jUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DropDownTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void preConditionRedirectionToWebSite() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void validateCheckBox() {
        driver.findElement(By.id("withOptGroup")).click();
        
    }
}
