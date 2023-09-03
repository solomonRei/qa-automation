package org.smeled.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.smeled.driver.WebDriverFactory;

import java.io.IOException;

import static org.smeled.driver.WebDriverFactory.getDriver;


public class Hooks {

    @Before
    public void beforeAutomationPractice() throws IOException {
        getDriver().get("https://bigshop.md");
    }

    @After
    public void afterAutomationPractice() {
        WebDriverFactory.quitDriver();
    }
}
