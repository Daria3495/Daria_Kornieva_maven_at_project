package chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;


public class SeleniumClassworkTest {

    public static void main(String[] args) throws MalformedURLException {
//    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }

}
