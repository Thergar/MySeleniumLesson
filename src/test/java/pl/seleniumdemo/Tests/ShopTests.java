package pl.seleniumdemo.Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.PageObjects.PaymentObject.Cart;
import pl.seleniumdemo.PageObjects.HomePage;
import pl.seleniumdemo.PageObjects.PaymentObject.Shop;
import pl.seleniumdemo.utils.BaseTest;

public class ShopTests extends BaseTest {

    @Test

    public void addingItemsToCart() {
        Shop shop = new HomePage(driver)
            .clickCartIcon()
            .returnToShop()
            .checkBddCucumber()
            .clickShopIcon()
            .checkGitBasics()
            .clickShopIcon()
            .checkJavaSeleniumWeb()
            .clickShopIcon();

        SoftAssert checkProperties = new SoftAssert();

        checkProperties.assertAll();

    }



    @Test
    public void test() {

        /*HomePage homePage = new HomePage(driver);

        homePage.openDropdownMenu();*/

        Cart cart = new HomePage(driver)
                .openDropdownMenu();

        System.out.println("dupa");

    }

}
