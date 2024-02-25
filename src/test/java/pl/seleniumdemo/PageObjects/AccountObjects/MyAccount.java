package pl.seleniumdemo.PageObjects.AccountObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

    protected WebDriver driver;

    public MyAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final int randomNumber = (int) (Math.random() * 500);

    private final String setEmail= "test22222@interia.pl";

    private String email = "Test" + randomNumber + "@gamil.com";

    private String password = "Test1234567!";

    private String logNick;

    @FindBy(xpath = "//h2[text()='Register']")
    private WebElement registerHeader;

    @FindBy(id = "reg_email")
    private WebElement regEmail;

    @FindBy(id = "reg_password")
    private WebElement regPassword;

    @FindBy(name = "register")
    private WebElement register;

    @FindBy(xpath = "//h2[text()='Login']")
    private WebElement loginHeader;

    @FindBy(id = "username")
    private WebElement logUsername;

    @FindBy(id = "password")
    private WebElement logPassword;

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(xpath = "//a[text()='Lost your password?']")
    private WebElement lostPassword;

    @FindBy(xpath = "//li//strong[text()='Error:']")
    private WebElement errors;

    public WebElement getLoginHeader() {

        return loginHeader;
    }

    public WebElement getRegisterHeader() {

        return registerHeader;
    }

    public MyAccount setEmail() {
        regEmail.sendKeys(setEmail);
        return this;
    }

    public MyAccount setPassword() {
        regPassword.sendKeys(password);
        return this;
    }

    public Account btnRegister() {
        register.click();
        return new Account(driver);
    }

    public MyAccount setLogUsername() {
        logUsername.sendKeys(setEmail);
        return this;
    }

    public MyAccount setLogPassword() {
        logPassword.sendKeys(password);
        return this;
    }

    public Account btnLogin() {
        login.click();
        return new Account(driver);
    }

    public WebElement errorWindow() {
        return errors;
    }

}
