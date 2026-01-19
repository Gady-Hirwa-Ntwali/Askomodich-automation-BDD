package stepDefinitions;

import Constants.EndPoints;
import Pages.AccountPage;
import domainObject.RegisterCredentials;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterStep {
    WebDriver driver;
    @Given("I am on the account page")
    public void registerPage() {
        driver = DriverFactory.getDriver();
        new AccountPage(driver).load(EndPoints.account);
    }

    @When("I fill in the form with invalid/valid data")
    public void fillTheForm(RegisterCredentials credentials){
        new AccountPage(driver).register(credentials.getUsername(), credentials.getPassword(), credentials.getEmail());
    }

    @And("I click on register")
    public void submit() throws InterruptedException {
        new AccountPage(driver).clickRegister();

    }

    @Then("I should get an email error message")
    public void emailErrorMessage() {
        new AccountPage(driver).registerEmailError();
    }

    @Then("I should see a success message")
    public void successMessage() {
        new AccountPage(driver).registerSuccess();
    }

    @Then("I should get a username error message")
    public void usernameErrorMessage() {
        //new AccountPage(driver).registerComfirmation();
    }

}
