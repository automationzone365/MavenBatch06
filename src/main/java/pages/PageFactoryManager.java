package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static LandingPage landingPage;
    private static RegistrationPage registrationPage;

    public static LandingPage getLandingPage(WebDriver driver){

       return landingPage==null? new LandingPage(driver) : landingPage;
    }

    public static RegistrationPage getRegistrationPage(WebDriver driver){
        return registrationPage==null? new RegistrationPage(driver): registrationPage;
    }

}
