package com.webshop.testcase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webshop.utils.Helper;

public class GiftCardsPageTest extends BaseTest{
    // Test methods for GiftCardsPage will be implemented here
    @Test
    public void testGiftCardsWithLogin()
    {
        logger = report.createTest("test gift cards page");
        homePage.clickLoginLink();
        logger.pass("clicked login link from home page");
        String loginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertTrue(loginPageTitle.contains("Login"));
        logger.pass("login page title verified successfully");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("entered email id");
        loginPage.enterPassword("Pass@123");
        logger.pass("entered password");
        loginPage.clickLoginButton();
        logger.pass("clicked login button");
        Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
        logger.pass("user logged in successful");
        homePage.clickGiftCardsMenu();
        logger.pass("clicked on gift-cards menu");
        Assert.assertTrue(giftCardsPage.getGiftCardPageTitle().contains("Gift"));
        logger.pass("successfully navigated to gift cards page");
        int expected = 4;
        int actual = giftCardsPage.getProductItemCount();
        logger.pass("get the products count from product grid");
        System.out.println(actual+" "+expected);
        Assert.assertEquals(actual, expected);
        logger.pass("actual count matches the expected count");
        loginPage.clickLogout();
        Helper.sleep();
        logger.pass("logged out successfully");
    }
}
