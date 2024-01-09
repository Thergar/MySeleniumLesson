package pl.seleniumdemo.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.seleniumdemo.utils.DriverFactory;

public class BaseTest {

    protected final WebDriver driver = DriverFactory.getDriver();
    @BeforeMethod
    public void setup() {
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

