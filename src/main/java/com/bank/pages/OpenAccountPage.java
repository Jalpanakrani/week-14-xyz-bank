package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userSelect")
    WebElement CustomerName;

    @FindBy(id = "currency")
    WebElement Currency;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement ProcessButton;

    public void searchCustomerfromdropdownlist(String searchCustomer) {
        selectByVisibleTextFromDropDown(CustomerName, searchCustomer);
        CustomListeners.node.log(Status.PASS, "Select Customer Name " + CustomerName.getText());
        Reporter.log("Search Customer Name '" + CustomerName.getText() + "<br>");
    }
    public void SelectCurrencyfromdropdownlist(String SelectCurrency) {
        selectByVisibleTextFromDropDown(Currency, SelectCurrency);
        CustomListeners.node.log(Status.PASS, "Select Currency " + Currency.getText());
        Reporter.log("Select Currency '" + Currency.getText() + "<br>");
    }
    public void clickOnProcessButton() {
        CustomListeners.node.log(Status.PASS, "click On Process Button : " + ProcessButton.getText());
        Reporter.log("Clicking on Process Button " + ProcessButton.getText() + "<br>");
        clickOnElement(ProcessButton);
    }
    public String  getTextFromPopUpWindow(){
        CustomListeners.node.log(Status.PASS,"get text frpm popup window "+"<br>");
        Reporter.log("get text frpm popup window "+"<br>");
        Alert alert= driver.switchTo().alert();
        return alert.getText();
    }
    public void acceptPopUp(){
        CustomListeners.node.log(Status.PASS,"Accept popup"+"<br>");
        Reporter.log("Accept popup"+"<br>");
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }}