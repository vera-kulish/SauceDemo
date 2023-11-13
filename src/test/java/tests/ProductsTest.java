package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.goToCart();
        assertEquals(cartPage.getItemName(), "Sauce Labs Bike Light");
        assertEquals(cartPage.getItemPrice(), "$9.99");
    }
}
