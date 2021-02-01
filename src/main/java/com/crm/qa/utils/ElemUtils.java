package com.crm.qa.utils;

import com.crm.qa.driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class ElemUtils {

    //class var
    private WebDriver driver;
    private JSUtils jsUtils;


    //Constructor
    public ElemUtils(WebDriver driver){
        this.driver = driver;
        this.jsUtils = new JSUtils(driver);
    }

    //Actions
    public WebElement getElement(By loc){
        WebElement element = driver.findElement(loc);
        if(DriverFactory.highlight.equals("true")){
            jsUtils.flash(element);
        }
        return element;
    }

    public List<WebElement> getAllElements(By loc){
        return driver.findElements(loc);
    }

    public void doSendKeys(By loc, String text){
        getElement(loc).clear();
        getElement(loc).sendKeys(text);
    }

    public void doClick(By loc){
        getElement(loc).click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
