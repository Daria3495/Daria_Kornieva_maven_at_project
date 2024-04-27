package automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTestsTestNg {

    protected WebDriver driver;

    @AfterTest
    public void closeDriver() {
//        Driver.quitDriver();
    }
}
