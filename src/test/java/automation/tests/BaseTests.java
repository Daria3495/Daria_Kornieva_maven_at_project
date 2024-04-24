package automation.tests;

import automation.driver.Driver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;
    @After
    public void closeDriver() {
 //       Driver.quitDriver();
    }
}
