package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComputersPage extends HomePage {
    // ============================Page Elements============================ //
    @FindBy(xpath="//h1[text()='Computers']") private WebElement computersHeader;
    @FindBy(xpath="//div[@class='sub-category-grid']/div") private List<WebElement> computerSubCategories;

    // ============================Page Initialization============================ //
    public ComputersPage() {
        PageFactory.initElements(driver, this);
    }

    // ============================Page Actions/Methods============================ //
    public String getComputersPageTitle() {
        String computersPageTitle = driver.getTitle();
        System.out.println("Computers Page Title: " + computersPageTitle);
        return computersPageTitle;
    }
    public int countComputerSubCategories() {
        int subCategoryCount = computerSubCategories.size();
        System.out.println("Number of Computer Subcategories: " + subCategoryCount);
        return subCategoryCount;
    }
}
