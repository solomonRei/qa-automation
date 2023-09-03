package org.smeled.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        // TODO: make for different browsers
        if (Objects.isNull(driver)) {
            System.setProperty("chromedriver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
