package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {

    public BankManagerLoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement AddCustomerButton;


    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement OpenAccountButton;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[3]")
    WebElement CustomersButton;


    public void clickOnAddCustomerButton() {
    //    CustomListeners.node.log(Status.PASS, "click On Add Customer Button : " + AddCustomerButton.getText());
        Reporter.log("Clicking on Add Customer Button " + AddCustomerButton.getText() + "<br>");
        clickOnElement(AddCustomerButton);
    }
    public void clickOnOpenAccountButton() {
    //    CustomListeners.node.log(Status.PASS, "click On Open Account Button : " + OpenAccountButton.getText());
        Reporter.log("Clicking on Open Account Button " + OpenAccountButton.getText() + "<br>");
        clickOnElement(OpenAccountButton);
    }
    public void clickOnCustomersButton() {
     //   CustomListeners.node.log(Status.PASS, "click On Home Button : " + CustomersButton.getText());
        Reporter.log("Clicking on Customers Button " + CustomersButton.getText() + "<br>");
        clickOnElement(CustomersButton);
    }
    }