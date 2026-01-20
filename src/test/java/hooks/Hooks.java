package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;
    @Before
    public void before(Scenario scenario){

        driver = DriverFactory.initializeDriver("chrome");
        System.out.println("start scenario");
        System.out.println("The scenario name " + scenario.getName());

    }
    @After
    public void after(Scenario scenario) {
        //driver.quit();
        System.out.println("End scenario");
        System.out.println("The scenario status" + scenario.getStatus());
    }
}
