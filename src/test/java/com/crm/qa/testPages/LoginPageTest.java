package com.crm.qa.testPages;

import com.crm.qa.baseTest.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifyLoginPageTitle(){
        String title = loginPage.getThisPageTitle();
        System.out.println(title);
    }

    @Test
    public void verifyDoLogin(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
}
