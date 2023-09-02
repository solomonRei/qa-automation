package org.smeled.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.smeled.pages.CartPage;

import static org.junit.Assert.assertTrue;

public class CheckoutSteps {
    private final WebDriver driver;
    private final CartPage cartPage;

    public CheckoutSteps() {
        this.driver = Hooks.getDriver();
        cartPage = new CartPage(driver);
    }

    @Given("the user has products in the cart")
    public void navigateToCart() {
//        String cartPageUrl = "https://bigshop.md/";
//        driver.get(cartPageUrl);
//        assertTrue("Cart count should be greater than 0", cartPage.getCartItemCount() > 0);
    }

    @When("the user goes to the cart")
    public void goToCart() {
        String cartPageUrl = "https://bigshop.md/ro/cart";
        driver.get(cartPageUrl);
    }

    @When("the user proceeds to checkout")
    public void proceedToCheckout() {
        cartPage.clickProceedToCheckoutButton();
    }

    @Then("the user should see the checkout page")
    public void verifyCheckoutPage() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://bigshop.md/ro/checkout";
        assert currentUrl.equals(expectedUrl) : "Expected checkout page, but got " + currentUrl;
    }
}

