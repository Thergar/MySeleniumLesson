package pl.seleniumdemo.PageObjects.PaymentObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    protected WebDriver driver;

    public Checkout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    //Optional field
    @FindBy(id = "billing_company")
    private WebElement companyName;

    @FindBy(id = "select2-billing_country-container")
    private WebElement countryContainer;

    @FindBy(id = "billing_address_1")
    private WebElement homeAddress;

    //Optional field
    @FindBy(id = "billing_address_2")
    private WebElement suiteNumber;

    @FindBy(id = "billing_postcode")
    private WebElement postcode;

    @FindBy(id = "billing_city")
    private WebElement townCity;

    @FindBy(id = "billing_phone")
    private WebElement phoneNumber;

    @FindBy(id = "order_comments")
    private WebElement comments;

    @FindBy(className = "woocommerce-NoticeGroup woocommerce-NoticeGroup-checkout")
    private WebElement errors;

    @FindBy(xpath = "Click here to enter your code")
    private WebElement couponCode;

    @FindBy(id = "coupon_code")
    private WebElement enterCoupon;

    @FindBy(name = "apply_coupon")
    private WebElement applyCouponBtn;

    @FindBy(className = "woocommerce-error")
    private WebElement couponError;

    @FindBy(id = "place_order")
    private WebElement placeorder;


    public Checkout name() {
        firstName.sendKeys("dupa");
        return new Checkout(driver);
    }
}
