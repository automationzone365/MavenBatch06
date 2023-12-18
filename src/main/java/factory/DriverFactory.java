package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static WebDriver initializeDriver(String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--remote-allow-orgins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                try {
                    EdgeOptions edgeOptions=new EdgeOptions();
                    edgeOptions.addArguments("start-maximized");
                    driver= new RemoteWebDriver(new URL("http://localhost:4444"),edgeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
               // driver = new EdgeDriver();
                break;
            default:
                System.out.println("invalid browser name, please give a valid one");
        }


        return driver;
    }

}
