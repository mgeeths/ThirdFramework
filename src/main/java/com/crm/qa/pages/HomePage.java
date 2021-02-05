package com.crm.qa.pages;

import com.crm.qa.utils.ElemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //class var
    private WebDriver driver;
    private ElemUtils elemUtils;
    private By contactsSideMenuLc = By.linkText("Contacts");


    //const
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.elemUtils = new ElemUtils(driver);
    }

    //Page Actions
    public ContactsPage navToContactsPage(){
        elemUtils.doClick(contactsSideMenuLc);
        return new ContactsPage(driver);
    }
}
