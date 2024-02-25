package pl.seleniumdemo.PageObjects.AccountObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account {

    protected WebDriver driver;

    public Account(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
    private WebElement mainText;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    @FindBy(linkText = "Orders")
    private WebElement ordersLink;

    @FindBy(linkText = "Downloads")
    private WebElement downloadsLink;

    @FindBy(linkText = "Addresses")
    private WebElement adressesLink;

    @FindBy(linkText = "Account details")
    private WebElement accDetailsLink;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(id = "account_first_name")
    private WebElement setFirstName;

    @FindBy(id = "account_last_name")
    private WebElement setLastName;

    @FindBy(name = "save_account_details")
    private WebElement saveChangeBtn;

    @FindBy(xpath = "//a[@class='woocommerce-Button button']")
    private WebElement goShop;

    public Account clickDasboard() {
        dashboardLink.click();
        return this;
    }

    public WebElement getMainText() {

        return mainText;
    }

    public Account clickOrders() {
        ordersLink.click();
        return this;
    }

    public Account goShop() {
        goShop.click();
        return this;
    }

    public Account clickDownloads() {
        downloadsLink.click();
        return this;
    }

    public Account clickAddresses() {
        adressesLink.click();
        return this;
    }

    public Account clickDetails() {
        accDetailsLink.click();
        return this;
    }
    public Account setFirstName() {
        setFirstName.sendKeys("Test");
        return this;
    }

    public Account setLastName() {
        setLastName.sendKeys("Testowy");
        return this;
    }

    public Account saveChanges() {
        saveChangeBtn.click();
        return this;
    }

    public MyAccount clickLogout() {
        logoutLink.click();
        return new MyAccount(driver);
    }
}
