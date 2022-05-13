package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginField;
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLoginButton;

    public void clickOnManagerLoginLink(){
     //   CustomListeners.node.log(Status.PASS,"click on manager link"+bankManagerLoginField.toString()+"<br>");
        Reporter.log("click on manager link"+bankManagerLoginField.toString()+"<br>");
        clickOnElement(bankManagerLoginField);
    }
    public void clickOnCustomerLoginButton(){
       // CustomListeners.node.log(Status.PASS,"click on log in button"+"<br>");
        Reporter.log("click on log in button"+"<br>");
        clickOnElement(customerLoginButton);
    }

}
