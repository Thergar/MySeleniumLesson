package pl.seleniumdemo.PageObjects.PaymentObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.utils.ElementHelper;

import java.util.List;
import java.util.NoSuchElementException;

public class Shop {

    protected WebDriver driver;

    public Shop(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@class='post-29 product type-product status-publish has-post-thumbnail product_cat-courses first instock shipping-taxable purchasable product-type-simple']//a[text()='Add to cart']")
    private WebElement bddCucumber;

    @FindBy(xpath = "//li[@class='post-29 product type-product status-publish has-post-thumbnail product_cat-courses first instock shipping-taxable purchasable product-type-simple']//a[text()='View cart']")
    private WebElement cucumberCart;

    @FindBy(xpath = "//li[@class='post-27 product type-product status-publish has-post-thumbnail product_cat-courses instock sale shipping-taxable purchasable product-type-simple']//a[text()='Add to cart']")
    private WebElement gitBasics;

    @FindBy(xpath = "//li[@class='post-27 product type-product status-publish has-post-thumbnail product_cat-courses instock sale shipping-taxable purchasable product-type-simple']//a[text()='View cart']")
    private WebElement gitCart;

    @FindBy(xpath = "//li[@class='post-8 product type-product status-publish has-post-thumbnail product_cat-courses instock sale shipping-taxable purchasable product-type-simple']//a[text()='Add to cart']")
    private WebElement javaSelenium;

    @FindBy(xpath = "//li[@class='post-8 product type-product status-publish has-post-thumbnail product_cat-courses instock sale shipping-taxable purchasable product-type-simple']//a[text()='View cart']")
    private WebElement javaSeleniumCart;

    @FindBy(xpath = "//img[@src='http://seleniumdemo.com/wp-content/uploads/2019/01/2067835_11b7_2-300x300.jpg']")
    private WebElement bddCucumberImg;

    @FindBy(xpath = "//img[@src='http://seleniumdemo.com/wp-content/uploads/2019/01/2103644_82a5_2-300x300.jpg']")
    private WebElement gitBasicsImg;

    @FindBy(xpath = "//img[@src='http://seleniumdemo.com/wp-content/uploads/2019/01/2018726_0044_2-300x300.jpg']")
    private WebElement getJavaSeleniumImg;

    @FindBy(xpath = "//i[@class='icn-shoppingcart']")
    private List<WebElement> shoppingCartIcon;

    @FindBy(xpath = "//select[@name='orderby']")
    private WebElement sort;
    public Cart checkBddCucumber() {
        /*ElementHelper.waitElementClicable(bddCucumber, driverjavaSeleniumCart, );*/
        bddCucumber.click();
        ElementHelper.waitElementClickable(driver, cucumberCart, 5, 500);
        cucumberCart.click();
        return new Cart(driver);
    }

    public Cart checkGitBasics() {
        gitBasics.click();
        ElementHelper.waitElementClickable(driver, gitCart, 5, 500);
        gitCart.click();
        return new Cart(driver);
    }

    public Cart checkJavaSeleniumWeb() {
        javaSelenium.click();
        ElementHelper.waitElementClickable(driver, javaSeleniumCart, 5, 500);
        javaSeleniumCart.click();
        return new Cart(driver);
    }

    public Shop addBddCucumber() {
        ElementHelper.waitBeforeClick(driver, bddCucumber, 5);
        bddCucumber.click();
        return new Shop(driver);
    }

    public Shop addGitBasics() {
        ElementHelper.waitBeforeClick(driver, gitBasics, 5);
        gitBasics.click();
        return new Shop(driver);
    }

    public Shop addJavaSeleniumWeb() {
        ElementHelper.waitBeforeClick(driver, javaSelenium, 5);
        javaSelenium.click();
        return new Shop(driver);
    }

    public Cart goToCart() {
        WebElement cartIcon = shoppingCartIcon
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element is invisible"));
        ElementHelper.waitBeforeClick(driver, cartIcon, 5);
        new Actions(driver).moveToElement(cartIcon).click().perform();
        return new Cart(driver);
    }
}
