package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.name("login")).click();
    }

    public void welcomeMessage(){
        String message = driver.findElement(By.xpath("(//p[contains(text(),'Hello')])[1]")).getText();
        System.out.println(message);
        assertEquals("Hello theGame (not theGame? Log out)", message);
    }

    public void register(String username, String password, String email){
        driver.findElement(By.id("reg_username")).sendKeys(username);
        driver.findElement(By.id("reg_password")).sendKeys(password);
        driver.findElement(By.id("reg_email")).sendKeys(email);
    }

    public void clickRegister() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("register")).click();
    }

    public void registerEmailError(){
        String errorMessage = driver.findElement(By.cssSelector(".woocommerce-error li")).getText();
        System.out.println(errorMessage);
       assertEquals("Error: An account is already registered with your email address. Please log in.", errorMessage);
    }

    public void registerSuccess(){
        String message = driver.findElement(By.xpath("(//p[contains(text(),'Hello')])[1]")).getText();
        System.out.println(message);
    }

//    public void registerUsernameError(){
//
//    }

}
