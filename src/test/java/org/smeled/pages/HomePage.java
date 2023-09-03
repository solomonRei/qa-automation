package org.smeled.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.smeled.actions.CommonActions;


public class HomePage {
    private final WebDriver driver;
    private final By titleLocator = By.tagName("title");
    private final By searchInputLocator = By.cssSelector("input[name='q']");
    private final By searchButtonLocator = By.cssSelector("button[type='submit']");

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public String getPageTitle() {
        return driver.findElement(titleLocator).getAttribute("text");
    }

    public void enterSearchQuery(String query) {
        WebElement searchInputButton = CommonActions.waitForElementToBeClickable(driver, searchInputLocator, 1);
        searchInputButton.sendKeys(query);
    }

    public void clickSearchButton() {
        WebElement searchButton = CommonActions.waitForElementToBeClickable(driver, searchButtonLocator, 3);
        searchButton.click();
    }

}
