package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final By SHOPPING_CART = By.id("shopping_cart_container");
    private String ADD_REMOVE_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String item) {
        By addToCartButton = By.xpath(String.format(ADD_REMOVE_PATTERN, item));
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(SHOPPING_CART).click();
    }

    public void removeFromCart(String item) {
        By addToCartButton = By.xpath(String.format(ADD_REMOVE_PATTERN, item));
        driver.findElement(addToCartButton).click();
    }
}
