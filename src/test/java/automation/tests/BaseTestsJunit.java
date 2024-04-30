package automation.tests;

import automation.driver.Driver;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class BaseTestsJunit {

    protected WebDriver driver;
    @After
    public void closeDriver() {
        Driver.quitDriver();
    }
}
