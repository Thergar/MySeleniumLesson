package pl.seleniumdemo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.PageObjects.AccountObjects.MyAccount;
import pl.seleniumdemo.PageObjects.PaymentObject.Cart;
import pl.seleniumdemo.PageObjects.PaymentObject.Shop;

import java.util.List;

public class HomePage {

    protected WebDriver driver;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Cart']")
    private List<WebElement> shoppingCartTopbar;

    @FindBy(xpath = "//span[text()='Shop']")
    private List<WebElement> shopTopbar;

    @FindBy(xpath = "//span[text()='My account']")
    private List<WebElement> accountTopbar;

    @FindBy(xpath = "//a[@href='#']")
    private List<WebElement> searchIcon;

/*    @FindBy(id = "s-65a6b51918fc6")
    private WebElement searchInput;*/

    @FindBy(xpath = "//a[@title='View your shopping cart']")
    private List<WebElement> shoppingCartIcon;

    @FindBy(xpath = "//div[@class='branding align-items-center flex-column ']")
    private WebElement centerBox;


    public Cart clickCartIcon() {
        shoppingCartTopbar
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return new Cart(driver);
    }

    public Shop clickShop() {
        shopTopbar
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return new Shop(driver);
    }

    public MyAccount clickAccount() {
        accountTopbar
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return new MyAccount(driver);
    }

    public HomePage clickSearchIcon() {
        searchIcon
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return new HomePage(driver);
    }

/*    public SearchResults searchFor() {
        ElementHelper.waitElementClickable(searchInput, driver);
        searchInput.click();
        ElementHelper.waitElementClickable(searchInput, driver);
        searchInput.sendKeys();
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResults(driver);*/

    public Cart viewShoppingCart() {
        shoppingCartIcon
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return new Cart(driver);
    }

    public Cart openDropdownMenu() {
        new Actions(driver).moveToElement(shoppingCartIcon
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .get()).click().perform();
        return new Cart(driver);
    }

    public WebElement checkCenterBox() {
        return centerBox;
    }
}
