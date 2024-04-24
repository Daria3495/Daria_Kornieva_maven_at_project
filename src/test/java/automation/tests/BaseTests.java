package automation.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;

    @Before
    public void initialize() {
//        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
