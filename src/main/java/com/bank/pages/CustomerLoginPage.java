package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    @FindBy(id = "userSelect")
    WebElement YourName;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement  LoginLink;

    @FindBy(xpath = "//label[normalize-space()='Your Name :']")
    WebElement yourNametextFeild;

    public void selectYourname(String SelectYourName) {
        selectByVisibleTextFromDropDown(YourName, SelectYourName);
      //  CustomListeners.node.log(Status.PASS, "Select Your Name " + YourName.getText());
        Reporter.log("Select Your Name '" + YourName.getText() + "<br>");
    }
        public void clickOnLoginLink(){
            CustomListeners.node.log(Status.PASS,"click On Login Link : " + LoginLink.getText());
            Reporter.log("Clicking on Login Link " + LoginLink.getText() + "<br>");
            clickOnElement(LoginLink);

        }
    public String getYourNameText(){
        CustomListeners.node.log(Status.PASS,"get text from your name tetx field"+yourNametextFeild.getText()+"br");
        Reporter.log("get text from your name tetx field"+yourNametextFeild.getText()+"br");
        return getTextFromElement(yourNametextFeild);
    }
}