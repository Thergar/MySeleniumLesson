package pl.seleniumdemo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults {

    protected WebDriver driver;

    public SearchResults(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h2[text()='Java Selenium WebDriver']")
    private WebElement javaSeleniumWebDriverTitle;

    @FindBy(xpath = "//h2[text()='GIT basics']")
    private WebElement gitBasicsTitle;

    @FindBy(xpath = "//h2[text()='BDD Cucumber']")
    private WebElement bddCucumberTitle;

    public WebElement checkJavaSeleniumTitle() {

        return javaSeleniumWebDriverTitle;
    }

    public WebElement checkGitBasicsTitle() {

        return gitBasicsTitle;
    }

    public WebElement checkBddCucumberTitle() {

        return bddCucumberTitle;
    }
}
