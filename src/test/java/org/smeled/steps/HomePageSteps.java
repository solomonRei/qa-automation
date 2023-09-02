package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.smeled.factory.WebDriverFactory;
import org.smeled.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class HomePageSteps {
    private final WebDriver driver;
    private final HomePage homePage;

    public HomePageSteps() {
        this.driver = WebDriverFactory.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Given("the user opens the browser")
    public void theUserOpensTheBrowser() {
        driver.manage().window().maximize();
    }

    @When("the user navigates to {string}")
    public void navigateToUrl(String url) {
        driver.navigate().to(url);
        System.out.println("MySampleTest.that_I_have_my_animals() ran!");
    }

    @Then("the website title should contain {string}")
    public void verifyWebsiteTitle(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        assertTrue("Website title should contain 'BigShop'", actualTitle.contains(expectedTitle));
    }

}

