package com.crm.qa.pages;

import com.crm.qa.utils.ElemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.rmi.runtime.NewThreadAction;

public class NewContactPage {

    //class var
    private WebDriver driver;
    private ElemUtils elemUtils;

    private By newContactsPageHeader = By.xpath("(//div[contains(@class, 'header')])[2]");
    private By fnameField= By.name ("first_name");
    private By lNameField= By.name ("last_name");
    private By coNameField= By.xpath ("//div[@name='company']/input[@class='search']");
    private By eMailField = By.xpath("//input[@placeholder='Email address']");
    private By eMailCategoryField = By.xpath("//input[@placeholder='Personal email, Business, Alt...']");
    private By addEmailBtn = By.xpath("(//i[@class='add icon'])[1]");
    private By altEmailField = By.xpath("(//input[@placeholder='Email address'])[2]");
    private By altEmailBtn = By.xpath("(//input[@placeholder='Personal email, Business, Alt...'])[2]");
    private By saveBtn = By.xpath("//button[contains(text(),'Save')]");


    @FindBy(xpath = "//div[@name='category']")
    WebElement categorySelectionField;

    @FindBy(xpath = "(//div[@class='visible menu transition']//div[@role='option'])[3]/span")
    WebElement customerCategoryOption;

    @FindBy(xpath = "//div[@name='status']")
    WebElement statusSelectionField;

    @FindBy(xpath = "(//div[@class='visible menu transition']//div[@role='option'])[3]/span")
    WebElement activeStatusOption;

    @FindBy(xpath="(//div[@class='ui toggle checkbox'])[1]")
    WebElement doNotCallBtn;

    @FindBy(xpath ="//input[@name='day']")
    WebElement dayField;

    @FindBy(xpath ="//div[@name='month']")
    WebElement monthField;

    @FindBy(xpath="(//div[@name='month']//div[@class='visible menu transition']//div[@role='option'])[3]/span")
    WebElement febMonth;

    @FindBy(xpath ="//input[@name='year']")
    WebElement yearField;

    @FindBy(xpath ="//input[@name='fileField']")
    WebElement imageField;


    //Const
    public NewContactPage(WebDriver driver){
        this.driver = driver;
        this.elemUtils = new ElemUtils(driver);
    }

    //Page Actions
    public String getPageHeader(){
        elemUtils.waitForElement(newContactsPageHeader);
        return elemUtils.getTextOfEle(newContactsPageHeader);
    }

    public void createNewContact(String fName, String lName, String coName, String eMail, String emailCat,
                                 String altEmail, String altEmailCat){
        elemUtils.doSendKeys(fnameField, fName);
        elemUtils.doSendKeys(lNameField, lName);
        elemUtils.doSendKeys(coNameField, coName);
        elemUtils.doSendKeys(eMailField, eMail);
        elemUtils.doSendKeys(eMailCategoryField, emailCat);
        elemUtils.doClick(addEmailBtn);
        elemUtils.doSendKeys(altEmailField, altEmail);
        elemUtils.doSendKeys(altEmailBtn,altEmailCat);
        elemUtils.doClick(saveBtn);
    }
}
