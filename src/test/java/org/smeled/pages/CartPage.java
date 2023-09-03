package org.smeled.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;

    private final By productRowLocator = By.cssSelector(".cart_page tbody tr");
    private final By proceedToCheckoutButtonLocator = By.cssSelector(".checkout_btn a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductAddedToCart(String productName) {
        java.util.List<WebElement> productRows = driver.findElements(productRowLocator);

        for (WebElement row : productRows) {
            if (row.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clickProceedToCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        WebElement proceedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButtonLocator));

        proceedButton.click();
    }
}
