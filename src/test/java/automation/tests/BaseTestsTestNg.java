package automation.tests;

import automation.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class BaseTestsTestNg {

    protected WebDriver driver;

    @AfterTest
    public void closeDriver() {
        Driver.quitDriver();
    }
}