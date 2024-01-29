package pages;

import lombok.extern.log4j.Log4j2;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage {

    private final By ITEM_NAME = By.cssSelector(".inventory_item_name");
    private final By ITEM_PRICE = By.cssSelector(".inventory_item_price");
    private final String REMOVE_FROM_CART_PATTERN = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button";
    private final By ITEM = By.cssSelector(".cart_item");
    private final By CHECKOUT = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the cart")
    public void open() {
        log.info("Open cart page");
        driver.get(BASE_URL + "cart.html");
    }

    @Step("Get the name of the item")
    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Get the price of the item")
    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Remove the item from cart")
    public void removeFromCart(String itemName) {
        log.info("Removing item '{}' from the cart", itemName);
        By removeButton = By.xpath(String.format(REMOVE_FROM_CART_PATTERN, itemName));
        driver.findElement(removeButton).click();
    }

    @Step("Get the amount of items in the cart")
    public int getItemsAmount() {
        return driver.findElements(ITEM).size();
    }

    @Step("Open checkout page")
    public void goToCheckout() {
        log.info("Go to checkout");
        driver.findElement(CHECKOUT).click();
    }
}
