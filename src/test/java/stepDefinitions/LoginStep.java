package stepDefinitions;

import Constants.EndPoints;
import Pages.AccountPage;
import domainObject.LoginCridentials;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    WebDriver driver;
    AccountPage accountPage;
    @Given("I am on the login page")
    public void loginPage() {
        driver = DriverFactory.getDriver();
        new AccountPage(driver).load(EndPoints.account);
    }

    @When("I enter valid credentials")
    public void enterValidCredentials(LoginCridentials loginCredentials) throws InterruptedException {
        new AccountPage(driver).login(loginCredentials.getEmail(),loginCredentials.getPassword());
    }

    @When("I click on login button")
    public void clickOnLoginButton() {

    }

    @Then("I should be redirected to the dashboard page")
    public void redirectToDashboard() {
        new AccountPage(driver).welcomeMessage();
    }

}
