package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(description = "Add item to the cart")
    public void addToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.goToCart();
        assertEquals(cartPage.getItemName(), "Sauce Labs Bike Light");
        assertEquals(cartPage.getItemPrice(), "$9.99");
    }

    @Test(description = "Remove item from the cart (Products page)")
    public void removeFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.removeFromCart("Sauce Labs Backpack");
        cartPage.open();
        assertEquals(cartPage.getItemsAmount(), 0, "Item was not removed from the cart");
    }
}
