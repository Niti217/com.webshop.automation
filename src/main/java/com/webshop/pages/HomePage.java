package com.webshop.pages;

import com.webshop.base.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverScript {
    // ============================Page Elements============================ //
   // @FindBy(linkText = "Log in") private WebElement loginLink;
   // @FindBy(linkText = "Log out") private WebElement logoutLink;
    @FindBy(xpath=("//a[@href='/books']")) private WebElement booksLink;
    private By logoutLink = By.linkText("Log out");
    private By loginLink = By.linkText("Log in");


    // ============================Page Initialization============================ //
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    // ============================Page Actions/Methods============================ //
    public String getHomePageTitle(){
        String homePageTitle = driver.getTitle();
        System.out.println("Home Page Title: " + homePageTitle);
        return homePageTitle;
    }
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
    public void clickLogoutLink() {
        driver.findElement(logoutLink).click();
    }
    public boolean isLogoutLinkDisplayed(){
        return driver.findElements(logoutLink).size()>0 && driver.findElement(logoutLink).isDisplayed();
    }
    public boolean isLoginLinkDisplayed(){
        return driver.findElements(loginLink).size()>0 && driver.findElement(loginLink).isDisplayed();
    }
    public void clickBooksLink() {
        booksLink.click();
    }


}
