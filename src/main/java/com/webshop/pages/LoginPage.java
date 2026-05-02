package com.webshop.pages;

import com.webshop.base.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverScript {
     // ============================Page Elements============================ //
        @FindBy(id="Email") private WebElement emailInput;
        @FindBy(name="Password") private WebElement passwordInput;
        @FindBy(id="RememberMe") private WebElement rememberMeCheckbox;
        @FindBy(linkText = "Forgot password?") private WebElement forgotPasswordLink;
        @FindBy(xpath="//input[@class='button-1 login-button']") private WebElement loginButton;
        @FindBy(xpath=("//li[contains(text(),'The credentials provided are incorrect')]")) private WebElement emptyPasswordErrorMessage;
        @FindBy(xpath=("//li[contains(text(),'No customer account found')]")) private WebElement emptyEmailErrorMessage;
        @FindBy(xpath=("//span[contains(text(),'Please enter a valid email address.')]")) private WebElement invalidEmailErrorMessage;

    // ============================Page Initialization============================ //
    //PageFactory is a class provided by Selenium to support the Page Object Model design pattern.
    //It is used to initialize the elements of the Page Object or instantiate the Page Objects itself.
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // ============================Page Actions/Methods============================ //
   public void doLogin(String email, String password) {
        enterEmailID(email);
        enterPassword(password);
        clickLoginButton();
    }
    public String getLoginPageTitle() {
        String title = driver.getTitle();
        System.out.println("Login Page Title: " + title);
        return title;
    }
    public String getEmptyPasswordErrorMessage() {
        String errorMessage = emptyPasswordErrorMessage.getText();
        System.out.println("Login Error Message: " + errorMessage);
        return errorMessage;
    }
    public String getEmptyEmailErrorMessage() {
        String errorMessage = emptyEmailErrorMessage.getText();
        System.out.println("Empty Email Error Message: " + errorMessage);
        return errorMessage;
    }
    public String getInvalidEmailErrorMessage() {
        String errorMessage = invalidEmailErrorMessage.getText();
        System.out.println("Invalid Email Error Message: " + errorMessage);
        return errorMessage;
    }

    public void enterEmailID(String email) {
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public boolean isRememberMeCheckboxSelected() {
        return rememberMeCheckbox.isSelected();
    }
    public boolean isForgotPasswordLinkDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }
    public void clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
    }


}
