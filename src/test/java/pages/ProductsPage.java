package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final By SHOPPING_CART = By.id("shopping_cart_container");
    private String ADD_REMOVE_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        log.info("Open products page");
        driver.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String item) {
        log.info("Add '{}' to the cart", item);
        By addToCartButton = By.xpath(String.format(ADD_REMOVE_PATTERN, item));
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        log.info("Go to the cart");
        driver.findElement(SHOPPING_CART).click();
    }

    public void removeFromCart(String item) {
        log.info("Remove '{}' from the cart", item);
        By addToCartButton = By.xpath(String.format(ADD_REMOVE_PATTERN, item));
        driver.findElement(addToCartButton).click();
    }
}
