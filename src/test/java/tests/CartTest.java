package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(description = "Remove item from the cart")
    public void removeFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.removeFromCart("Sauce Labs Fleece Jacket");
        assertEquals(cartPage.getItemsAmount(), 0, "Item was not removed from the cart");
    }

    @Test(description = "Checkout opens from cart")
    public void goToCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.goToCheckout();
        assertEquals(checkoutPage.getTitle(),"Checkout: Your Information");
    }
}
