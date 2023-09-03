package org.smeled.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.smeled.actions.CommonActions;


public class ProductPage {
    private final WebDriver driver;

    private final By addToCartButtonLocator = By.cssSelector(".product_variant button.button");
    private final By productNameLocator = By.xpath("//h1[@itemprop='name']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton() {
        WebElement addToCartButton = CommonActions.waitForElementToBeClickable(driver, addToCartButtonLocator, 2);
        addToCartButton.click();
    }

    public String getProductName() {
        return driver.findElement(productNameLocator).getText();
    }
}
