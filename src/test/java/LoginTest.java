import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    public void successfulLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Products");
    }

    @Test
    public void emptyFields() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        assertEquals(driver.findElement(By.cssSelector("[data-test='error']")).getText(), "Epic sadface: Username is required");
    }

    @Test
    public void wrongPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauc");
        driver.findElement(By.id("login-button")).click();
        assertEquals(driver.findElement(By.xpath("[data-test='error']")).getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockedUser() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertEquals(driver.findElement(By.xpath("[data-test='error']")).getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
