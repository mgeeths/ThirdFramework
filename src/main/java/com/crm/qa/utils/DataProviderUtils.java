package com.crm.qa.utils;

import java.util.ArrayList;
import java.util.List;

public class DataProviderUtils {

    //class var
    private ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\browse\\Automation\\FrameworkThree\\src\\test\\resources\\testData\\FreeCRMData.xlsx");



    //const
    public DataProviderUtils(){
    }

    //Actions
    public ArrayList<Object[]> getNewContactData(){
        ArrayList<Object[]> newContactList = new ArrayList<>();
        int rowCount = excelUtils.getRowCount("NewContacts");
        for(int i=2; i<= rowCount; i++){
            String fName = excelUtils.getCellData("NewContacts","Firstname", i);
            String lName = excelUtils.getCellData("NewContacts","Lastname", i);
            String coName = excelUtils.getCellData("NewContacts","CompanyName", i);
            String eMail = excelUtils.getCellData("NewContacts","Email", i);
            String eMailCat = excelUtils.getCellData("NewContacts","EmailCat", i);
            String altEmail = excelUtils.getCellData("NewContacts","AltEmail", i);
            String altEmailCat = excelUtils.getCellData("NewContacts","AltEmailCat", i);
            newContactList.add(new Object[]{fName,lName,coName,eMail,eMailCat,altEmail,altEmailCat});
        }

        return newContactList;
    }

}

