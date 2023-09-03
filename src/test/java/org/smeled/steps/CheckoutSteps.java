package org.smeled.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.smeled.pages.CartPage;

import static org.smeled.driver.WebDriverFactory.getDriver;

public class CheckoutSteps {
    private final WebDriver driver;
    private final CartPage cartPage;

    public CheckoutSteps() {
        this.driver = getDriver();
        cartPage = new CartPage(driver);
    }

    @Given("the user has products in the cart")
    public void navigateToCart() {
        System.out.println("User has products in the cart");
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

