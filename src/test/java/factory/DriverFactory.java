package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver = switch (browser) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
                yield new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
                yield new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Invalid Browser" + browser);
        };

        driver.manage().window().maximize();
        DriverFactory.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
}
