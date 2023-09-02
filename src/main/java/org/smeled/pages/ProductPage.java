package org.smeled.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver driver;

    private final By addToCartButtonLocator = By.cssSelector(".product_variant.quantity button.button");
    private final By productNameLocator = By.xpath("//h1[@itemprop='name']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButtonLocator).click();
    }

    public String getProductName() {
        return driver.findElement(productNameLocator).getText();
    }
}
