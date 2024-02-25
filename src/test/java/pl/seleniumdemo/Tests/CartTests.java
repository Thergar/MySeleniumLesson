package pl.seleniumdemo.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.PageObjects.PaymentObject.Cart;
import pl.seleniumdemo.PageObjects.PaymentObject.Checkout;
import pl.seleniumdemo.PageObjects.PaymentObject.ProductPage;
import pl.seleniumdemo.PageObjects.HomePage;
import pl.seleniumdemo.utils.BaseTest;

public class CartTests extends BaseTest {

    @Test
    public void checkingHeaders() {

        Cart cart = new HomePage(driver)
                .clickShop()
                .addBddCucumber()
                .goToCart();

        //Table headers assertions
        SoftAssert checkHeaders = new SoftAssert();
        checkHeaders.assertEquals(cart.checkRemover().getText(), " ");
        checkHeaders.assertEquals(cart.checkThumbnailHeader().getText(), " ");
        checkHeaders.assertEquals(cart.checkNameHeader().getText(), "PRODUCT");
        checkHeaders.assertEquals(cart.checkPriceHeader().getText(), "PRICE");
        checkHeaders.assertEquals(cart.checkQuantityHeader().getText(), "QUANTITY");
        checkHeaders.assertEquals(cart.checkSubtotalHeader().getText(), "TOTAL");
    }

    @Test
    public void CheckingRemoveButton() {

        Cart cart = new HomePage(driver)
                .clickShop()
                .addBddCucumber()
                .goToCart()
                .removeItem()
                .clickUndo()
                .removeItem();

        Assert.assertEquals(cart.checkCartEmptiness().getText(), "Your cart is currently empty.");
    }

    @Test
    public void checkingInteractiveNameProduct() {

        ProductPage productPage = new HomePage(driver)
                .clickShop()
                .addGitBasics()
                .goToCart()
                .clickProductName();

        Assert.assertEquals(productPage.checkHeader().getText(),"GIT basics");
    }

    @Test
    public void checkingInteractiveImgElement() {

        ProductPage productPage = new HomePage(driver)
                .clickShop()
                .addJavaSeleniumWeb()
                .goToCart()
                .clickProductImg();

        Assert.assertEquals(productPage.checkHeader().getText(), "Java Selenium WebDriver");;
    }

    //This test covers "apply coupon" and "update cart" function.
    @Test
    public void checkingUpdateOption() {


        Cart cart = new HomePage(driver)
                .clickShop()
                .addBddCucumber()
                .goToCart()
                .addQuantity()
                .clickUpdateCart();

        SoftAssert checkText = new SoftAssert();
        checkText.assertEquals(cart.checkItemPrice().getText(), "9,99 zł");
        checkText.assertEquals(cart.checkSubtotalPrice().getText(), "19,98 zł");
        checkText.assertAll();

        Checkout checkout = new Cart(driver)
                .clickCheckoutBtn();
               // .name();
    }
}


