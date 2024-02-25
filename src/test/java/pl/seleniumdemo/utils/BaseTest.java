package pl.seleniumdemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pl.seleniumdemo.utils.DriverFactory;


public class BaseTest {

    protected final WebDriver driver = DriverFactory.getDriver();

    @BeforeMethod
    public void setup() {
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

