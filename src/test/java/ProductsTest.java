import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void buyProduct() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']/ancestor::*[@class='inventory_item']//button")).click();
        
        driver.findElement(By.id("shopping_cart_container")).click();
        assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText(), "Sauce Labs Bike Light");
        assertEquals(driver.findElement(By.cssSelector(".inventory_item_price")).getText(), "$9.99");
    }
}
