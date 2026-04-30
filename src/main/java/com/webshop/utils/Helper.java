package com.webshop.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Helper {
    /*
     * Method to capture screenshot and return the file path
     */
    public static String captureScreenshot(WebDriver driver) {
        // Code to capture screenshot and save it to a file
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = System.getProperty("user.dir") + "/src/test/resources/report/screenshots/";
        new File(screenshotDir).mkdirs(); // Create the directory if it doesn't exist
        String destination = screenshotDir + "screenshot_" + System.currentTimeMillis() + ".png";
        try {
            FileHandler.copy(src, new File(destination));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destination;
    }



}
