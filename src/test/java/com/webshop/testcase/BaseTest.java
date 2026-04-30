package com.webshop.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.base.DriverScript;
import com.webshop.pages.BooksPage;
import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;
import com.webshop.utils.Helper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class BaseTest extends DriverScript {

    public static ExtentTest logger;
    public static ExtentReports report;
    HomePage homePage;
    LoginPage loginPage;
    BooksPage booksPage;

    @BeforeSuite
    public void setupReport(){
        ExtentHtmlReporter extent = new ExtentHtmlReporter("./src/test/resources/report/screenshots/exe-report.html");
        report = new ExtentReports();
        report.attachReporter(extent);
    }
    @BeforeMethod
    public void setup(){
        initApplication();
        launchApplication();
        homePage = new HomePage();
        loginPage = new LoginPage();
        booksPage = new BooksPage();
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            try {
                String screenshotPath = Helper.captureScreenshot(driver);
                // Convert image to base64 for proper embedding in Extent Report
                byte[] imageBytes = Files.readAllBytes(Paths.get(screenshotPath));
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                /*logger.fail("Test Failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());*/
                logger.fail("Test Failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        report.flush();
        quitApplication();
    }
}
