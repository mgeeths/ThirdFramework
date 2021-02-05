package com.crm.qa.testPages;

import com.crm.qa.baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactsPageTest  extends BaseTest {

    @BeforeClass
    public void contactsPageSetUp(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.navToContactsPage();
        contactsPage.getContactsPageHeader();
    }

    @Test
    public void verifyGetAllRows(){
        contactsPage.getAllRows();
    }
}
