package stepDefinitions;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.PageFactoryManager;
import utils.ConfigLoader;
import utils.PropertyUtils;

public class LandingPagestepdef {
    private final LandingPage landingPage;

    public LandingPagestepdef(DriverContext context){
        landingPage=PageFactoryManager.getLandingPage(context.driver);
    }

    @Given("I am on the AutomationZone shopping page")
    public void load() {
       // String url=  PropertyUtils.propertyLoader("src/test/resources/prod_config.properties").getProperty("baseURL");
        String url=ConfigLoader.getInstance().getURL();
        landingPage.loadApplication(url);

    }

    @When("I enter my username {string} and password {string}")
    public void logintoAccount(String username, String password) {
        landingPage.closenotification();
        landingPage.loginMenuclick();
        landingPage.enterUsername(username);
        landingPage.enterPassword(password);
        landingPage.loginClick();
    }

    @Then("the users {string} logged in successfully")
    public void theUsersLoggedInSuccessfully(String username) {
        System.out.println(username + "logged in successfully");
    }
}
