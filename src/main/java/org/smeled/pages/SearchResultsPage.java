package org.smeled.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    private final WebDriver driver;

    private final By searchResultsLocator = By.cssSelector(".row.no-gutters.shop_wrapper");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areSearchResultsDisplayed() {
        WebElement searchResultsElement = driver.findElement(searchResultsLocator);

        List<WebElement> childElements = searchResultsElement.findElements(By.xpath(".//*"));

        return !childElements.isEmpty();
    }
}
