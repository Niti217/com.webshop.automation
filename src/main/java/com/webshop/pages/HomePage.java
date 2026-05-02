package com.webshop.pages;

import com.webshop.base.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends DriverScript {
    // ============================Page Elements============================ //
   // @FindBy(linkText = "Log in") private WebElement loginLink;
   // @FindBy(linkText = "Log out") private WebElement logoutLink;
    private By booksLink = By.xpath("(//a[contains(text(),'Books')])[1]");
    private By computersLink = By.xpath("(//a[contains(text(),'Computers')])[1]");
    private By logoutLink = By.linkText("Log out");
    private By loginLink = By.linkText("Log in");
    private WebDriverWait wait;

    // ============================Page Initialization============================ //
    public HomePage(){
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // ============================Page Actions/Methods============================ //
    private void click(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Failed to click element: " + locator);
    }
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
        click(booksLink);
    }
    public void clickComputersLink() {
        click(computersLink);
    }


}
