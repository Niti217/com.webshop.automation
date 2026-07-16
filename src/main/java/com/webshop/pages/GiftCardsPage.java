package com.webshop.pages;

import java.util.List;

import com.webshop.base.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GiftCardsPage extends DriverScript {
    // ============================Page Elements============================ //

    @FindBy(xpath = "//h1[text()='Gift Cards']")
    WebElement giftCardText;
    @FindBy(xpath = "//div[@class='product-grid']")
    WebElement productGrid;
    @FindBy(xpath = "//div[@class='product-grid']/div[@class='item-box']")
    List<WebElement> productItemBox;

    // ============================Page Initialization============================ //
    //PageFactory is a class provided by Selenium to support the Page Object Model design pattern.
    //It is used to initialize the elements of the Page Object or instantiate the Page Objects itself.
    public GiftCardsPage() {
        PageFactory.initElements(driver, this);
    }

    // ============================Page Actions/Methods============================ //

    public String getGiftCardPageTitle() {
        return driver.getTitle();
    }

    public String getGiftCardText() {
        return giftCardText.getText();
    }

    public boolean isProductGridDisplayed() {
        return productGrid.isDisplayed();
    }

    public int getProductItemCount() {
        return productItemBox.size();
    }
}
