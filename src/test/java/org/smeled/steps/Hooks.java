package org.smeled.steps;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.smeled.factory.WebDriverFactory;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void beforeScenario() {
        if (driver == null) {
            driver = WebDriverFactory.getDriver();
        }
    }

    public void closeDriver() {
        WebDriverFactory.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
