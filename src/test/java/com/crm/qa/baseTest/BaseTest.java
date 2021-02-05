package com.crm.qa.baseTest;

import com.crm.qa.driverFactory.DriverFactory;
import com.crm.qa.pages.*;
import com.crm.qa.utils.DataProviderUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.ConcurrentModificationException;
import java.util.Properties;

public class BaseTest {

    //class var
    private WebDriver driver;
    private DriverFactory df;
    public Properties prop;

    public LoginPage loginPage;
    public CommonPage commonPage;
    public ContactsPage contactsPage;
    public HomePage homePage;
    public NewContactPage newContactPage;
    public DataProviderUtils dataProviderUtils;
    @BeforeTest
    public void setUp(){
        df = new DriverFactory();
        prop = df.init_prop();
        driver = df.init_driver();

        driver.get(prop.getProperty("appUrl"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        commonPage = new CommonPage(driver);
        contactsPage = new ContactsPage(driver);
        homePage = new HomePage(driver);
        newContactPage = new NewContactPage(driver);
        dataProviderUtils = new DataProviderUtils();

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
