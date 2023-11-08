import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest{

    @Test
    public void locators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button"));
        driver.findElement(By.name("login-button"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//div[contains(@class,'logo')]"));
        driver.findElement(By.xpath("//*[text()='standard_user']//ancestor::div"));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();

    }
}
