package parametrization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class ParallelRun {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(ParallelRun::go).start(); // конструктор принимает раннабле
        }
    }

    public static void go() {
        try {
            ChromeOptions options = new ChromeOptions();
            WebDriver driver = new RemoteWebDriver(URI.create("http://localhost:4444").toURL(), options);
            driver.get("https://www.google.com/");
            Thread.sleep(5000);
            driver.quit();
        } catch (InterruptedException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
