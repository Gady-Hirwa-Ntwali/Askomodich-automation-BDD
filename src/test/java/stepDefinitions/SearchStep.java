package stepDefinitions;

import Pages.StorePage;
import domainObject.SearchProduct;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SearchStep {
    WebDriver driver = DriverFactory.getDriver();

    @When("I enter {searchProduct} in the search field")
    public void interInSearchField(SearchProduct searchProduct) {
        new StorePage(driver).enterProduct(searchProduct.getProductName());
    }

    @And("I click on the search button")
    public void clicksSearchButton() {
        new StorePage(driver).clickSearch();
    }

    @Then("I should see only  {searchProduct} on the storePage")
    public void searchResult(SearchProduct searchProduct) {
       new StorePage(driver) .searchResult(searchProduct.getProductName());
    }
}
