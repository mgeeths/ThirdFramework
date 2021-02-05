package com.crm.qa.pages;

import com.crm.qa.utils.ElemUtils;
//import org.apache.logging.log4j.LogManager;
import com.crm.qa.utils.LogUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //class var
    private By usernameLc = By.name("email");
    private By passwordLc = By.name("password");
    private By loginBtn = By.cssSelector("div.button");
    private By loginPageHeader = By.xpath("(//div[contains(@class, 'header')])[1]");
    private ElemUtils elemUtils;
    private final Logger logger = LogManager.getLogger(LoginPage.class);

    //Constructor
    public LoginPage(WebDriver driver){
        elemUtils = new ElemUtils(driver);

    }

    //Page Actions

    public String getThisPageTitle(){
        LogUtils.fatal("My fatal message to be logged");
        return elemUtils.getPageTitle();
    }

    public void doLogin(String username, String password){
        LogUtils.debug("My debug message to be logged");
        elemUtils.doSendKeys(usernameLc,username);
        elemUtils.doSendKeys(passwordLc,password);
        elemUtils.doClick(loginBtn);
        elemUtils.waitForElement(loginPageHeader);
    }

}
