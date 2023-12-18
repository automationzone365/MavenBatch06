package stepDefinitions;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Teststeps {

    @Given("a registered user with userid \"(.*)\" and password \"(.*)\"$")
    public void login(String userName, String password){
     System.out.println(userName);
     System.out.println(password);
    }


    @When("the user enters the credentials and click on submit button")
    public void step2() {
        System.out.println(" I am in step 2");
    }

    @Then("the system should authenticate the user {string}")
    public void step3(String username) {
        System.out.println("I am in step3 "+ username);
    }

    @Given("I am registered user with username \"(.*)\" and with password \"(.*)\"$")
    public void iAmRegisteredUserWithUsernameAndWithPassword(String username, String password) {
        System.out.println(username);
        System.out.println(password);

    }

    @Given("the user enters the table creds")
    public void userdataviaDatatable(DataTable userCreds) {
        List<List<String>> data=userCreds.asLists();
        System.out.println(data.get(0).get(0));
        System.out.println(data.get(0).get(1));
        System.out.println(data.get(1).get(0));
        System.out.println(data.get(1).get(1));

    }


    @Given("the user entered the creds")
    public void theUserEnteredTheCreds(DataTable creds) {
        List<Map<String,String>> data=creds.asMaps(String.class,String.class);
        System.out.println(data.get(0).get("username"));
        System.out.println(data.get(0).get("password"));
        System.out.println(data.get(1).get("username"));
        System.out.println(data.get(1).get("password"));
    }

    @Given("I am using JSON data")
    public void iAmUsingJSONData(String jsonData) {
      String user=  JsonPath.parse(jsonData).read("$.users[2].name");
      String age=   JsonPath.parse(jsonData).read("$.users[2].age");
      System.out.println(user);
      System.out.println(age);

    }



}
