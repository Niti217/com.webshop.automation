package com.webshop.testcase;

import com.webshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginPageTitle() {
        logger=report.createTest("Test Login Page Title");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        String loginPageTitle = loginPage.getLoginPageTitle();
        logger.pass("Fetched Login Page Title");
        Assert.assertTrue(loginPageTitle.contains("Login"), "Login page title does not contain 'login'");
        logger.pass("Verified Login Page Title contains 'Login'");
    }
    @Test(priority = 2)
    public void testValidLogin() {
        logger=report.createTest("Test Valid Login");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("Entered Email ID");
        loginPage.enterPassword("Pass@123");
        logger.pass("Entered Password");
        loginPage.clickLoginButton();
        logger.pass("Clicked on Login Button");
        homePage.isLogoutLinkDisplayed();
        logger.pass("Checked if Logout Link is displayed");
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        logger.pass("Verified Logout Link is displayed");
        String homePageTitle = homePage.getHomePageTitle();
        logger.pass("Fetched Home Page Title");
        Assert.assertTrue(homePageTitle.contains("Demo Web Shop"), "Home page title does not contain 'Demo Web Shop'");
        logger.pass("Verified Home Page Title contains 'Demo Web Shop'");
        homePage.clickLogoutLink();
        logger.pass("Clicked on Logout Link");
    }
    @Test(priority = 3)
    public void testEmptyPassword() {
        logger=report.createTest("Test Empty Password");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("Entered Email ID");
        loginPage.clickLoginButton();
        logger.pass("Clicked on Login Button");
        String loginErrorMessage = loginPage.getEmptyPasswordErrorMessage();
        logger.pass("Fetched Empty Password Error Message");
        Assert.assertTrue(loginErrorMessage.contains("The credentials provided are incorrect"), "Login error message does not contain 'The credentials provided are incorrect'");
        logger.pass("Verified Login Error Message contains 'The credentials provided are incorrect'");
    }
    @Test(priority = 4)
    public void testEmptyEmail() {
        logger=report.createTest("Test Empty Email");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        loginPage.enterPassword("Pass@123");
        logger.pass("Entered Password");
        loginPage.clickLoginButton();
        logger.pass("Clicked on Login Button");
        String emptyEmailErrorMessage = loginPage.getEmptyEmailErrorMessage();
        logger.pass("Fetched Empty Email Error Message");
        Assert.assertTrue(emptyEmailErrorMessage.contains("No customer account found"), "Empty email error message does not contain 'No customer account found'");
        logger.pass("Verified Empty Email Error Message contains 'No customer account found'");
    }
    @Test(priority = 5)
    public void testIncorrectEmailAddress() {
        logger=report.createTest("Test Incorrect Email Address");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        loginPage.enterEmailID("adf215@");
        logger.pass("Entered Incorrect Email ID");
        loginPage.enterPassword("Pass@123");
        logger.pass("Entered Password");
        loginPage.clickLoginButton();
        logger.pass("Clicked on Login Button");
        String invalidEmailErrorMessage = loginPage.getInvalidEmailErrorMessage();
        logger.pass("Fetched Invalid Email Error Message");
        Assert.assertTrue(invalidEmailErrorMessage.contains("Please enter a valid email address"), "Invalid email error message does not contain 'Please enter a valid email address'");
        logger.pass("Verified Invalid Email Error Message contains 'Please enter a valid email address'");
    }
    @Test(priority = 6)
    public void testRememberMeChecked() {
        logger=report.createTest("Test Remember Me Checked");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("Entered Email ID");
        loginPage.enterPassword("Pass@123");
        logger.pass("Entered Password");
        if (!loginPage.isRememberMeCheckboxSelected()) {
            loginPage.clickRememberMeCheckbox();
        }
        logger.pass("Checked Remember Me Checkbox");
        loginPage.clickLoginButton();
        logger.pass("Clicked on Login Button");
        homePage.isLogoutLinkDisplayed();
        logger.pass("Checked if Logout Link is displayed");
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        logger.pass("Verified Logout Link is displayed");
        String homePageTitle = homePage.getHomePageTitle();
        logger.pass("Fetched Home Page Title");
        Assert.assertTrue(homePageTitle.contains("Demo Web Shop"), "Home page title does not contain 'Demo Web Shop'");
        logger.pass("Verified Home Page Title contains 'Demo Web Shop'");
        //homePage.clickLogoutLink();
        driver.quit();
        logger.pass("Closed the Browser");
        //Reopen Browser and navigate to the application URL
        initApplication();
        logger.pass("Re-initialized the Application");
        launchApplication();
        logger.pass("Launched the Application");
        // Re-instantiate page objects with the new driver
        homePage=new HomePage();
        logger.pass("Re-instantiated HomePage Object");
        //Verify that the user is still logged in and is on the home page after reopening the browser
        Assert.assertTrue(homePage.isLogoutLinkDisplayed(),"User Should be logged in!");
        logger.pass("Verified User is still logged in after reopening the browser");
    }
    @Test(priority = 7)
    public void testRememberMeUnchecked(){
        logger=report.createTest("Test Remember Me Unchecked");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("Entered Email ID");
        loginPage.enterPassword("Pass@123");
        logger.pass("Entered Password");
        if (loginPage.isRememberMeCheckboxSelected()) {
            loginPage.clickRememberMeCheckbox();
        }
        logger.pass("Unchecked Remember Me Checkbox");
        loginPage.clickLoginButton();
        logger.pass("Clicked on Login Button");
        homePage.isLogoutLinkDisplayed();
        logger.pass("Checked if Logout Link is displayed");
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        logger.pass("Verified Logout Link is displayed");
        String homePageTitle = homePage.getHomePageTitle();
        logger.pass("Fetched Home Page Title");
        Assert.assertTrue(homePageTitle.contains("Demo Web Shop"), "Home page title does not contain 'Demo Web Shop'");
        logger.pass("Verified Home Page Title contains 'Demo Web Shop'");
        //Close Browser
        driver.quit();
        logger.pass("Closed the Browser");
        //Reopen Browser and navigate to the application URL
        initApplication();
        logger.pass("Re-initialized the Application");
        launchApplication();
        logger.pass("Launched the Application");
        // Re-instantiate page objects with the new driver
        homePage=new HomePage();
        logger.pass("Re-instantiated HomePage Object");
        //Verify that the user is not logged in and is on the home page after reopening the browser
        Assert.assertTrue(homePage.isLoginLinkDisplayed(),"User Should not be logged in!");
        logger.pass("Verified User is not logged in after reopening the browser");
    }
    @Test(priority = 8)
    public void testInValidLoginFunctionScreenshot() {
        logger=report.createTest("Test Invalid Login Function with Screenshot");
        homePage.clickLoginLink();
        logger.pass("Clicked on Login Link");
        loginPage.enterEmailID("selauto1@test.com");
        logger.pass("Entered Email ID");
        loginPage.enterPassword("00000");
        logger.pass("Entered Password");
        loginPage.clickLoginButton();
        logger.pass("Clicked on Login Button");
        homePage.isLogoutLinkDisplayed();
        logger.pass("Checked if Logout Link is displayed");
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        logger.pass("Verified Logout Link is displayed");
        String homePageTitle = homePage.getHomePageTitle();
        logger.pass("Fetched Home Page Title");
        Assert.assertTrue(homePageTitle.contains("Demo Web Shop"), "Home page title does not contain 'Demo Web Shop'");
        logger.pass("Verified Home Page Title contains 'Demo Web Shop'");
        homePage.clickLogoutLink();
        logger.pass("Clicked on Logout Link");
    }
}
