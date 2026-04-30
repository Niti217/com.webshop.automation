package com.webshop.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {
    // ============================Test Cases============================ //
   @Test(priority = 1)
    public void testBooksPageTitle() {
        homePage.clickBooksLink();
        String booksPageTitle = booksPage.getBooksPageTitle();
        Assert.assertTrue(booksPageTitle.contains("Books"), "Books page title does not contain  'Books'");
    }

    @Test(priority = 2)
    public void testAddToCartFunctionality() throws InterruptedException {
       homePage.clickBooksLink();
       booksPage.clickFirstAddToCartButton();
       Thread.sleep(2000); // Wait for the cart update to process
    }
}

