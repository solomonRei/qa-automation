package org.smeled.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.smeled.pages.HomePage;

import static org.junit.Assert.assertTrue;


public class HomePageSteps {
    private final WebDriver driver;
    private final HomePage homePage;

    public HomePageSteps() {
        this.driver = Hooks.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("the user opens the browser")
    public void theUserOpensTheBrowser() {
        driver.manage().window().maximize();
    }

    @When("the user navigates to {string}")
    public void navigateToUrl(String url) {
        driver.navigate().to(url);
        System.out.println("WebSite Is Open and ran!");
    }

    @Then("the website title should contain {string}")
    public void verifyWebsiteTitle(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        actualTitle = actualTitle.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        assertTrue("Website title should contain 'BigShop'", actualTitle.contains(expectedTitle));
    }

}

