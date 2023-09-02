package org.smeled.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.smeled.pages.HomePage;
import org.smeled.pages.SearchResultsPage;

import static org.junit.Assert.assertTrue;

public class SearchSteps {
    private final WebDriver driver;
    private final HomePage homePage;
    private final SearchResultsPage searchResultsPage;

    public SearchSteps() {
        this.driver = Hooks.getDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Given("the user is on the BigShop homepage")
    public void navigateToHomePage() {
//        String baseUrl = "https://bigshop.md/";
//
//        driver.get(baseUrl);
    }

    @When("the user searches for {string}")
    public void searchForProduct(String product) {
        homePage.enterSearchQuery(product);
        homePage.clickSearchButton();
    }

    @Then("search results should be displayed")
    public void verifySearchResultsDisplayed() {
        assertTrue("Search results should be displayed", searchResultsPage.areSearchResultsDisplayed());
    }
}
