package com.crm.qa.testPages;

import com.crm.qa.baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewContactPageTest extends BaseTest {

    @BeforeClass
    public void newContactPgSetup(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @BeforeMethod
    public void goBackToContactsPage(){
        homePage.navToContactsPage();
        contactsPage.navToNewContactsPage();
    }

    @DataProvider
    public Iterator<Object[]> getNewContactsData(){
        ArrayList<Object[]> myTestData = dataProviderUtils.getNewContactData();
        return myTestData.iterator();
    }

    @Test(dataProvider = "getNewContactsData")
    public void verifyNewContactCreation(String fName, String lName, String coName, String eMail, String eMailCat, String altEmail, String altEmailCat){
        newContactPage.createNewContact(fName, lName, coName, eMail, eMailCat, altEmail, altEmailCat);
    }
}
