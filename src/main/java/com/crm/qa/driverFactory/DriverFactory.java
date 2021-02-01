package com.crm.qa.driverFactory;

import com.crm.qa.utils.JSUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    //class var
    private Properties prop;
    //public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private OptionsManager optionsManager;
    public static String highlight;
    //No Constructor

    //Actions
    public Properties init_prop(){
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public WebDriver init_driver(){
        String browserName = prop.getProperty("browser");
        optionsManager = new OptionsManager(prop);
        highlight = prop.getProperty("highlight").trim();
        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();

            tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

        }
        else if(browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            //driver = new ChromeDriver();
            tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
        }
        else if(browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else if(browserName.equals("safari")){
            tlDriver.set(new SafariDriver());
        }
        return getDriver();
    }

    public WebDriver getDriver(){
        return tlDriver.get();
    }

    public String getScreenshot(){
        File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png" ;
        File destinaton = new File(path);
        try {
            FileUtils.copyFile(srcFile,destinaton);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
