package pl.seleniumdemo.PageObjects.PaymentObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    protected WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[@class='product_title entry-title']")
    private WebElement gitHeader;

    public WebElement checkHeader() {
        return gitHeader;
    }
}
