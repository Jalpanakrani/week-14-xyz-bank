package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class WithdrowAccountPage extends Utility {
    public WithdrowAccountPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountField;

    @FindBy(xpath = "//div[@class=\"ng-scope\"]/descendant::button[6]")
    WebElement withdrowButton;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement successfullyWithdrowText;

    public  void enterAmount(String num){
        Reporter.log("Enter amount"+num+"<br>");
        sendTextToElement(amountField,num);
    }
    public  void clickOnWithdrow(){
        CustomListeners.node.log(Status.PASS,"click on withdrow"+"<br>");
        Reporter.log(("click on withdrow"+"<br>"));
        clickOnElement(withdrowButton);
    }
    public String getSuccessFullyWithdrowText(){
       CustomListeners.node.log(Status.PASS,"get successfully withdrowal tex"+successfullyWithdrowText.getText()+"<brb>");
        Reporter.log("get successfully withdrowal tex"+successfullyWithdrowText.getText()+"<brb>");
        return  successfullyWithdrowText.getText();
    }

}
