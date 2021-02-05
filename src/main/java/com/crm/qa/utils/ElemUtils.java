package com.crm.qa.utils;

import com.crm.qa.driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

public class ElemUtils {

    //class var
    private WebDriver driver;
    private JSUtils jsUtils;
    private WebDriverWait wait;



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

    public void sendEnterKey(By loc){
        driver.findElement(loc).sendKeys(Keys.ENTER);
    }

    public void waitForElement(By loc){
        wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.presenceOfElementLocated(loc));
    }

    public String getTextOfEle(By loc){
        return getElement(loc).getText();
    }
}
