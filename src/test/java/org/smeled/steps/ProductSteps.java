package org.smeled.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.smeled.pages.CartPage;
import org.smeled.pages.ProductPage;

import static org.junit.Assert.assertTrue;

public class ProductSteps {
    private final WebDriver driver;
    private final ProductPage productPage;
    private final CartPage cartPage;
    private String productName;

    public ProductSteps() {
        this.driver = Hooks.getDriver();
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Given("the user is on the product page")
    public void navigateToProductPage() {
        String productPageUrl = "https://bigshop.md/ro/product/laptop-xiaomi-mi-notebook-lite-15-6-intel-core-i5-e58504d1d-p89423";
        driver.get(productPageUrl);
        productName = productPage.getProductName();
    }

    @When("the user adds a {string} to the cart")
    public void addToCart(String product) {
        productPage.clickAddToCartButton();
    }

    @Then("the cart should contain the added product")
    public void verifyProductInCart() {
        assertTrue("The cart should contain the added product", cartPage.isProductAddedToCart(productName));
    }
}
