package com.crm.qa.testPages;

import com.crm.qa.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommonPagesTest extends BaseTest {

    @BeforeClass
    public void commonPageSetup(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @DataProvider
    public Object[][] getSearchNames(){
        return new Object[][]{{"Payal"},{"Sheetal"}, {"Rupal"}, {"Monal"}};
    }

    @Test
    public void verifyDoSearch(){
        commonPage.doSearch("Payal");
        String header = commonPage.getSearchResultHeader();
        Assert.assertTrue(commonPage.checkValueOfSearchResults("Payal"));
    }
}
