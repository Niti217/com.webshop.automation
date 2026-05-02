package com.webshop.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputersPageTest extends BaseTest {
    // ============================Test Cases============================ //
    @Test(priority = 1)
    public void testComputersPageTitle() {
        logger=report.createTest("Verify Computers Page Title");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login link");
        loginPage.doLogin("selauto1@test.com", "Pass@123");
        logger.pass("Logged in with valid credentials");
        homePage.clickComputersLink();
        logger.pass("Clicked on Computers link");
        String computersPageTitle = computersPage.getComputersPageTitle();
        logger.pass("Retrieved Computers page title");
        Assert.assertEquals(computersPageTitle, "Demo Web Shop. Computers", "Computers page title does not match expected value");
        logger.pass("Verified Computers page title successfully");
        homePage.clickLogoutLink();
        logger.pass("Clicked on Logout link");
    }
    @Test (priority = 2)
    public void testComputerSubCategoriesCount() {
        logger = report.createTest("Verify Computer Subcategories Count");
        homePage.clickLoginLink();
        loginPage.doLogin("selauto1@test.com", "Pass@123");
        logger.pass("Logged in with valid credentials");
        homePage.clickComputersLink();
        logger.pass("Clicked on Computers link");
        int count = computersPage.countComputerSubCategories();
        Assert.assertEquals(count, 3, "Number of computer subcategories does not match expected value");
        logger.pass("Verified number of computer subcategories successfully");
        homePage.clickLogoutLink();
        logger.pass("Clicked on Logout link");
    }
}
