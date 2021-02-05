package com.crm.qa.pages;

import com.crm.qa.utils.ElemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactsPage {

    //class var
    private WebDriver driver;
    private ElemUtils elemUtils;
    private By allRowsLc = By.xpath("tbody/tr");
    private By contactsPageHeader = By.xpath("(//div[contains(@class, 'header')])[2]");
    private By newContactsBtn = By.xpath("//button[contains(text(),'New')]");



    //constructor
    public ContactsPage(WebDriver driver){
        this.driver = driver;
        this.elemUtils = new ElemUtils(driver);
    }

    //Page Actions

    public String getContactsPageHeader(){
        elemUtils.waitForElement(contactsPageHeader);
        return elemUtils.getElement(contactsPageHeader).getText();
    }
    public void getAllRows(){
        List<WebElement> allRows = elemUtils.getAllElements(allRowsLc);
        System.out.println(allRows.size());
    }

    public NewContactPage navToNewContactsPage(){
        elemUtils.doClick(newContactsBtn);
        return new NewContactPage(driver);
    }
}
