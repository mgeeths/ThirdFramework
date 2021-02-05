package com.crm.qa.pages;

import com.crm.qa.utils.ElemUtils;
import com.crm.qa.utils.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonPage {

    //class var
    private By searchFieldLc = By.cssSelector("input[placeholder]");
    private By searchLc = By.cssSelector("div.input input");
    private By searchResultHeader = By.xpath("(//div[contains(@class, 'header')])[2]");
    private By allRowsLc = By.xpath("//tbody//tr");
    private By allRowsLc1 = By.cssSelector("tbody>tr");
    private ElemUtils elemUtils;
    private JSUtils jsUtils;


    //Constructor
    public CommonPage(WebDriver driver){
        elemUtils = new ElemUtils(driver);
        jsUtils = new JSUtils(driver);

    }

    //Page Actions
    public void doSearch(String text){
        elemUtils.doSendKeys(searchLc, text);
        elemUtils.sendEnterKey(searchFieldLc);
    }

    public String getSearchResultHeader(){
        return elemUtils.getElement(searchResultHeader).getText();
    }

    public boolean checkValueOfSearchResults(String text){
        List<WebElement> allRows = elemUtils.getAllElements(allRowsLc);
        System.out.println(allRows.size());

        for(WebElement e: allRows){
            String rowValue = e.findElement(By.xpath(".//td[2]/a")).getText();
            if(! rowValue.contains(text)){
                return false;
            }
        }
        return true;
    }
}
