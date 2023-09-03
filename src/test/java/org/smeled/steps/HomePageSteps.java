package org.smeled.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.smeled.actions.CommonActions;
import org.smeled.pages.HomePage;

import static org.junit.Assert.assertTrue;
import static org.smeled.driver.WebDriverFactory.getDriver;

public class HomePageSteps {
    private final WebDriver driver;
    private final HomePage homePage;

    public HomePageSteps() {
        driver = getDriver();
        homePage = new HomePage(driver);
    }

    @Given("the user opens the browser")
    public void theUserOpensTheBrowser() {
        System.out.println("ok");
    }

    @When("the user navigates to {string}")
    public void navigateToUrl(String url) {
        CommonActions.openUrl(driver, url);
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

