package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.goToCheckout();
        checkoutPage.fillDataAndContinue("Vera", "Kulish", "12345");
        assertEquals(checkoutOverviewPage.getTitle(), "Checkout: Overview", "Wrong page opened after continuing");
    }

    @Test
    public void allEmptyFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.goToCheckout();
        checkoutPage.fillDataAndContinue("", "", "");
        assertEquals(checkoutPage.getError(),"Error: First Name is required");
    }

    @Test
    public void emptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.goToCheckout();
        checkoutPage.fillDataAndContinue("Vera", "", "12345");
        assertEquals(checkoutPage.getError(),"Error: Last Name is required");
    }

    @Test
    public void emptyPostalCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.goToCheckout();
        checkoutPage.fillDataAndContinue("Vera", "Kulish", "");
        assertEquals(checkoutPage.getError(),"Error: Postal Code is required");
    }
}
