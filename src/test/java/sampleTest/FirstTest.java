package sampleTest;

import factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LandingPage;
import pages.PageFactoryManager;

public class FirstTest {
    public static void main(String args[]){

         WebDriver driver= DriverFactory.initializeDriver("chrome");
         driver.get("https://www.automationzone.in");
         LandingPage landingPage=PageFactoryManager.getLandingPage(driver);
         landingPage.closenotification();
         landingPage.loginMenuclick();
         landingPage.enterUsername("Test12user");
         landingPage.enterPassword("Password@123#$");
         landingPage.loginClick();
         driver.quit();



    }
}
