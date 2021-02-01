package com.crm.qa.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

    //class var
    private Properties prop;
    private ChromeOptions co;
    private FirefoxOptions fo;

    //constructor
    public OptionsManager(Properties prop){
        this.prop = prop;
    }

    //Actions
    public ChromeOptions getChromeOptions(){
        ChromeOptions co = new ChromeOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless"))){
            co.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito"))){
            co.addArguments("--incognito");
        }
        return co;
    }

    public FirefoxOptions getFirefoxOptions(){
        FirefoxOptions fo = new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless"))){
            fo.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito"))){
            fo.addArguments("--incognito");
        }
        return fo;
    }

}
