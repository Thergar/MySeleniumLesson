package pl.seleniumdemo.PageObjects.PaymentObject;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.utils.ElementHelper;

import java.util.List;
import java.util.NoSuchElementException;

public class Cart {

    protected WebDriver driver;


    public Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopIcon;

    @FindBy(xpath = "//th[@class='product-name']")
    private WebElement nameColumnHeader;

    @FindBy(xpath = "//th[@class='product-remove']")
    private WebElement removeColumnHeader;

    @FindBy(xpath = "//th[@class='product-thumbnail']")
    private WebElement imgColumnHeader;

    @FindBy(xpath = "//th[@class='product-price']")
    private WebElement priceColumnHeader;

    @FindBy(xpath = "//th[@class='product-quantity']")
    private WebElement quantityColumnHeader;

    @FindBy(xpath = "//th[@class='product-subtotal']")
    private WebElement totalPriceColumnHeader;

    @FindBy(xpath = "//td[@class='product-remove']")
    private List<WebElement> remove;

    @FindBy(xpath = "//td[@class='product-thumbnail']//a[contains(@href, 'seleniumdemo')]")
    private List<WebElement> productIcon;

    @FindBy(xpath = "//td[@class='product-name']//a[contains(@href, 'seleniumdemo')]")
    private List<WebElement> productName;

    @FindBy(xpath = "//td[@class='product-price']")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//input[contains(@id, 'quantity_')]")
    private List<WebElement> productQuantity;

    @FindBy(xpath = "//td[@class='product-subtotal']")
    private List<WebElement> productSubtotal;

    @FindBy(xpath = "//div[@id='tc-page-wrap']//div[@id='main-wrapper']//a[@class='checkout-button button alt wc-forward']")
    private WebElement proceedCheckoutBtn;

    @FindBy(xpath = "//button[text()='Apply coupon']")
    private WebElement applyCouponBtn;

    @FindBy(className = "woocommerce-error")
    private WebElement couponWarning;

    @FindBy(id = "coupon_code")
    private WebElement couponCode;

    @FindBy(xpath = "//button[@name='update_cart']")
    private WebElement updateCartBtn;

    @FindBy(xpath = "//*[@class='button wc-backward']")
    private WebElement returnToShopBtn;

    @FindBy(className = "restore-item")
    private WebElement undo;

    @FindBy(className = "cart-empty")
    private WebElement emptyCartText;


    public WebElement checkRemover() {
        return removeColumnHeader;
    }

    public WebElement checkThumbnailHeader() {
        return imgColumnHeader;
    }

    public WebElement checkNameHeader() {
        return nameColumnHeader;
    }

    public WebElement checkPriceHeader() {
        return priceColumnHeader;
    }

    public WebElement checkQuantityHeader() {
        return quantityColumnHeader;
    }

    public WebElement checkSubtotalHeader() {
        return totalPriceColumnHeader;
    }

    public WebElement checkCartEmptiness() {
        return emptyCartText;
    }

    public Shop returnToShop() {
        returnToShopBtn.click();
        return new Shop(driver);
    }

    public Cart clickUndo() {
        ElementHelper.waitElementClickable(driver, undo, 5, 500);
        undo.click();
        return this;
    }

    public Cart removeItem() {
        remove
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return this;
    }
    public ProductPage clickProductImg() {
        WebElement img = productIcon
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element is unclicable"));

        ElementHelper.waitBeforeClick(driver, img, 5);
        new Actions(driver).moveToElement(img).click().perform();
        return new ProductPage(driver);
    }

    public ProductPage clickProductName() {
        WebElement name = productName
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element is unclickable"));

        ElementHelper.waitBeforeClick(driver, name, 5);
        new Actions(driver).moveToElement(name).click().perform();
    return new ProductPage(driver);
    }

    public WebElement checkItemPrice() {
        return productPrice
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .get();
    }

    public Cart addQuantity() {

        productQuantity
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(add -> {
                    add.clear();
                    add.click();
                    add.sendKeys("2");
                });
        return this;
    }

    public WebElement checkSubtotalPrice() {
        WebElement subtotal = productSubtotal
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .get();
        return subtotal;
    }

    public WebElement checkCouponAlert() {
        ElementHelper.waitElementVisible(driver, couponWarning);
        return couponWarning;
    }

    public Cart clickUpdateCart() {
        ElementHelper.waitElementClickable(driver, updateCartBtn,  5, 500);
        updateCartBtn.click();
        ElementHelper.stalenessElements(driver, productSubtotal
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .get(), 5, 500);
        return this;
    }

    public Cart enterCouponCode() {
        ElementHelper.waitBeforeClick(driver, couponCode, 5);
        couponCode
                .sendKeys("test123");
        ElementHelper.waitElementVisible(driver,applyCouponBtn);
        return new Cart(driver);
    }

    public Cart applyCoupon() {
        ElementHelper.waitBeforeClick(driver, applyCouponBtn, 5);
        applyCouponBtn.click();
        return new Cart(driver);
    }

    public Checkout clickCheckoutBtn() throws ElementClickInterceptedException {
        ElementHelper.waitElementClickable(driver, proceedCheckoutBtn, 5, 500);
        proceedCheckoutBtn.click();
        //new Actions(driver).moveToElement(proceedCheckoutBtn).doubleClick(proceedCheckoutBtn).perform();
        return new Checkout(driver);
    }

    public Shop clickShopIcon() {
        shopIcon.click();
        return new Shop(driver);
    }
}
