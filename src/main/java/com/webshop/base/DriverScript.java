package com.webshop.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverScript {

    public static WebDriver driver;
    Properties prop;
    /*
     * Constructor to load the config properties file
     */
    public DriverScript() {
        try {
            File file = new File("./src/test/resources/config/config.properties");
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to load the config file: " + e.getMessage());
        }
    }

    /*
     * Method to initialize the WebDriver based on the browser specified in the config file
     */
    public void initApplication() {
        String browser = prop.getProperty("browser");
        if(browser.trim().equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        } else {
            System.out.println("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    /*
     * Method to launch the application URL specified in the config file
     */
    public void launchApplication() {
        String url = prop.getProperty("url");
        driver.get(url);
    }
    /*
     * Method to quit the WebDriver and close the application
     */
    public void quitApplication() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
