package com.webshop.pages;

import com.webshop.base.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends DriverScript {

    // ============================Page Elements============================ //
    @FindBy(xpath = ("(//input[@value='Add to cart'])[1]")) private WebElement firstAddToCartButton;
    @FindBy(linkText = "Shopping cart") private WebElement shoppingCartLink;

    // ============================Page Initialization============================ //
    //PageFactory is a class provided by Selenium to support the Page Object Model design pattern.
    //It is used to initialize the elements of the Page Object or instantiate the Page Objects itself.
    public BooksPage() {
        PageFactory.initElements(driver, this);
    }

    // ============================Page Actions/Methods============================ //
    public String getBooksPageTitle() {
        String title = driver.getTitle();
        System.out.println("Books Page Title: " + title);
        return title;
    }
    public void clickFirstAddToCartButton() {
        firstAddToCartButton.click();
    }
    public void clickShoppingCartLink() {
        shoppingCartLink.click();
    }

}
