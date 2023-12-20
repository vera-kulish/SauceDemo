package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Ignore
public class LocatorTest extends BaseTest{

    @Test
    public void locators() {
        driver.get("https://www.saucedemo.com/");
        String windowHandle = driver.getWindowHandle();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();

        driver.findElement(By.tagName("noscript"));
        driver.findElement(By.linkText("Sauce Labs Backpack")).click();
        driver.navigate().back();
        driver.findElement(By.partialLinkText("T-Shirt")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//div[contains(@class,'logo')]"));
        driver.findElement(By.xpath("//button[contains(text(),'cart')]")).click();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']/ancestor::a")).click();
        driver.navigate().back();
        driver.findElements(By.xpath("//*[@class='inventory_item']/descendant::img")).get(0).click();
        driver.navigate().back();
        driver.findElements(By.xpath("//*[@id='inventory_container']/following::a")).get(0).click();
        driver.switchTo().window(windowHandle);
        assertEquals(driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-onesie']/parent::div/div")).getText(), "$7.99");
        driver.findElement(By.xpath("//*[@class='title']/preceding::div[@id='shopping_cart_container']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id='shopping_cart_container' and @class='shopping_cart_container']")).click();

        driver.findElement(By.cssSelector(".bm-burger-button"));
        driver.findElement(By.cssSelector(".bm-item.menu-item"));
        driver.findElement(By.cssSelector(".bm-item-list .bm-item"));
        driver.findElement(By.cssSelector("#logout_sidebar_link"));
        driver.findElements(By.cssSelector("nav"));
        driver.findElements(By.cssSelector("a.bm-item"));
        driver.findElement(By.cssSelector("[id='react-burger-menu-btn']"));
        driver.findElements(By.cssSelector("[class~='bm-']"));
        driver.findElements(By.cssSelector("[class|='cart']"));
        driver.findElements(By.cssSelector("[href^='https']"));
        driver.findElements(By.cssSelector("[id$='link']"));
        driver.findElements(By.cssSelector("[id*='btn]"));
    }
}