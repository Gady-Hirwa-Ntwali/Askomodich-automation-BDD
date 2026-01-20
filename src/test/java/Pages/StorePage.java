package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StorePage extends BasePage {
    @FindBy(css = "a.added_to_cart.wc-forward") private WebElement viewCartLink;
    @FindBy(css = "td[class='product-name'] a" ) private WebElement actualProductName;
    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName){
        By product = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");

        wait.until(ExpectedConditions.elementToBeClickable(product)).click();

    }
    public void clickViewCart(int productQuantity, String productName){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        String quantity = driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");

        assertEquals(productQuantity, Integer.parseInt(quantity));
        assertEquals(productName,actualProductName.getText());
        System.out.println("Product added to cart name is " + productName);
    }

    public void selectCategory(String category){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("product_cat"))).click();
        Select select = new Select(driver.findElement(By.id("product_cat")));
        select.selectByVisibleText(category);
        System.out.println("Category selected is " + driver.findElement(By.cssSelector(".woocommerce-products-header h1")).getText());

    }

    public void enterProduct(String searchField){
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys(searchField);
    }

    public void clickSearch(){
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void searchResult(String searchField){
        String productNotFound = driver.findElement(By.cssSelector("#main > div > p")).getText();
        String result = driver.findElement(By.cssSelector(".woocommerce-products-header h1")).getText();
        System.out.println(result);
        assertTrue(result.contains(searchField));

        if(productNotFound.isEmpty()){
            System.out.println(result);
        }else{
            System.out.println(productNotFound);
        }
    }

}

