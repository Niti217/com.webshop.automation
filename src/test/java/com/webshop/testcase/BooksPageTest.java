package com.webshop.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {
    // ============================Test Cases============================ //
   @Test(priority = 1)
    public void testBooksPageTitle() {
        homePage.clickLoginLink();
        loginPage.doLogin("selauto1@test.com", "Pass@123");
        homePage.clickBooksLink();
        String booksPageTitle = booksPage.getBooksPageTitle();
        Assert.assertTrue(booksPageTitle.contains("Books"), "Books page title does not contain  'Books'");
        homePage.clickLogoutLink();
    }

    @Test(priority = 2)
    public void testAddToCartFunctionality() {
       homePage.clickLoginLink();
       loginPage.doLogin("selauto1@test.com", "Pass@123");
       homePage.clickBooksLink();
       booksPage.clickFirstAddToCartButton();
       homePage.clickLogoutLink();

    }
}

