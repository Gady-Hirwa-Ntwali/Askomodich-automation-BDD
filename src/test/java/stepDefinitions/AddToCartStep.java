package stepDefinitions;

import Constants.EndPoints;
import domainObject.Product;
import factory.DriverFactory;
import Pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class AddToCartStep {
    WebDriver driver;
    @Given("I am on the store/product page")
    public void imOnTheStorePage() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(EndPoints.store);

    }

    @When("I add {product} to the cart")
    public void iAddToTheCart(Product product) {
        new StorePage(driver).addToCart(product.getName());
    }


    @Then("I see {int} {product} in the cart")
    public void iSeeInTheCart(int productQuantity, Product product) {
        new StorePage(driver).clickViewCart(productQuantity, product.getName());
    }
}
