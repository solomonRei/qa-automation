package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.smeled.factory.WebDriverFactory;

public class Hooks {

    @Before
    public void beforeScenario()
    {
        WebDriver driver = WebDriverFactory.getDriver();
    }
    @After
    public void afterScenario() {
        WebDriverFactory.quitDriver();
    }
}
