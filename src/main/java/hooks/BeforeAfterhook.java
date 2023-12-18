package hooks;

import context.DriverContext;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class BeforeAfterhook {
    private final DriverContext driverContext;

    private WebDriver driver;
    public BeforeAfterhook(DriverContext driverContext){
     this.driverContext=driverContext;
    }
    @Before
    public void before(Scenario scenario){
      driver= DriverFactory.initializeDriver(System.getProperty("browser","firefox"));
      driverContext.driver=driver;
    }

    @After
    public void after(Scenario scenario){
        driver.quit();
    }
}
