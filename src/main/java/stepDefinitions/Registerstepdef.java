package stepDefinitions;

import context.DriverContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.LandingPage;
import pages.PageFactoryManager;
import pages.RegistrationPage;

import java.util.List;
import java.util.Map;

public class Registerstepdef {

    private final RegistrationPage registrationPage;
    private final LandingPage landingPage;

    public Registerstepdef(DriverContext context){
        registrationPage= PageFactoryManager.getRegistrationPage(context.driver);
        landingPage= PageFactoryManager.getLandingPage(context.driver);
    }

    @And("I am a new user registered")
    public void registerNewUser(DataTable userregdata) {
        List<Map<String,String>> data= userregdata.asMaps(String.class,String.class);
        landingPage.closenotification();
        landingPage.loginMenuclick();
        registrationPage.switch_to_registersection();
        registrationPage.setRegUsername(data.get(0).get("username"));
        registrationPage.setRegEmail(data.get(0).get("email"));
        registrationPage.setRegPassword(data.get(0).get("password"));
        registrationPage.register();

        Assert.assertEquals(landingPage.getUserLoggedinLabel(),"Hello "+data.get(0).get("username")+" (not "+data.get(0).get("username")+"? Log out)");

    }

    @And("I log out from the application")
    public void iLogOutFromTheApplication() {
        landingPage.signOut();
    }
}
