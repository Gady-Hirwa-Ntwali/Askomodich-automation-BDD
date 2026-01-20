package stepDefinitions;

import Constants.EndPoints;
import Pages.StorePage;
import domainObject.Category;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CategoryStep {
    WebDriver driver;
    @Given("am  on the store page")
    public void amOnTheStorePage() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(EndPoints.store);
    }
    @When("input the category {category}")
    public void inputTheCategory(Category category) {
        new StorePage(driver).selectCategory(category.getCategory());
    }
    @Then("I should see the products in the category {category} only")
    public void iShouldSeeSelectedProductOnly(Category category) {
        //new StorePage(driver).verifyCategory(category.getCategory());
    }
}
