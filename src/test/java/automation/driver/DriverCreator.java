package automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverCreator {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }
    public static void initializeDriver() {
        driver = new ChromeDriver();
    }

}
