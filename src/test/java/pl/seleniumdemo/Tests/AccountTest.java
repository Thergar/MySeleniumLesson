package pl.seleniumdemo.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.PageObjects.AccountObjects.Account;
import pl.seleniumdemo.PageObjects.HomePage;
import pl.seleniumdemo.utils.BaseTest;

public class AccountTest extends BaseTest {

    @Test
    public void createAccountTest() {

        Account account = new HomePage(driver)
                .clickAccount()
                .setEmail()
                .setPassword()
                .btnRegister();
    }

    @Test
    public void LoginAccountTest() {

        Account account = new HomePage(driver)
                .clickAccount()
                .setLogUsername()
                .setLogPassword()
                .btnLogin();

        Assert.assertTrue(account.getMainText().getText().contains("Hello"));

        account.clickOrders();
        Assert.assertTrue(account.getMainText().getText().contains("No order has been made yet."));

        account.clickDownloads();
        Assert.assertTrue(account.getMainText().getText().contains("No downloads available yet."));

        account.clickDetails()
                .setFirstName()
                .setLastName()
                .saveChanges();

        account.clickAddresses();

        SoftAssert addresses = new SoftAssert();
        addresses.assertTrue(account.getMainText().getText().contains("The following addresses will be used on the checkout page by default."));
        addresses.assertTrue(account.getMainText().getText().contains("Test Testowy"));
        addresses.assertAll();

        account.clickLogout();
    }
}
