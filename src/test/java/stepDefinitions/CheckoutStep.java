package stepDefinitions;

import Constants.EndPoints;
import Pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import factory.DriverFactory;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckoutStep {
    WebDriver driver;
    @Given("I have a product in cart")
    public void checkoutPageGiven() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(EndPoints.store);
        new StorePage(driver).addToCart("Basic Blue Jeans");
        new StorePage(driver).clickViewCart(1, "Basic Blue Jeans");

    }

    @And("I'm on checkout page")
    public void productInCart(){
        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
    }
    @When("I provide billing details")
    public void provideBillingDetails( List<Map<String, String>> billingDetails) throws InterruptedException {
        driver.findElement(By.id("billing_first_name")).sendKeys(billingDetails.getFirst().get("firstName"));
        driver.findElement(By.id("billing_last_name")).sendKeys(billingDetails.getFirst().get("lastName"));

        Select country = new Select(driver.findElement(By.id("billing_country")));
        country.selectByVisibleText(billingDetails.getFirst().get("country"));

        driver.findElement(By.id("billing_address_1")).sendKeys(billingDetails.getFirst().get("address"));
        driver.findElement(By.id("billing_city")).sendKeys(billingDetails.getFirst().get("city"));
        Thread.sleep(5000);
        Select state = new Select(driver.findElement(By.id("billing_state")));
        state.selectByVisibleText(billingDetails.getFirst().get("state"));

        driver.findElement(By.id("billing_postcode")).sendKeys(billingDetails.getFirst().get("zipCode"));
        driver.findElement(By.id("billing_email")).sendKeys(billingDetails.getFirst().get("email"));
    }

    @And("I place order")
    public void placeOrder() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("place_order")).click();

        // code to place the order
    }

    @Then("the order should be placed successfully")
    public void checkoutPageThen() throws InterruptedException {
        Thread.sleep(5000);
        String confirmationMessage = driver.findElement(By.cssSelector(".woocommerce-order p")).getText();
        System.out.println(confirmationMessage);
        assertEquals("Thank you. Your order has been received.", confirmationMessage);
    }
}
