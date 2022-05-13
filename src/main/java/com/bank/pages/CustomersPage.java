
package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomersPage extends Utility {

    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logOutButton;
    @FindBy(xpath = "//button[@ng-click=\"deposit()\"]")
    WebElement deposit;
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withDrow;

    public void  clickOnLOgOut(){
        CustomListeners.node.log(Status.PASS,"click on log out"+"<br>");
        Reporter.log("click on log out"+"<br>");
        clickOnElement(logOutButton);
    }
    public  boolean customerLogOutButtonIsDisplayed(){
        CustomListeners.node.log(Status.PASS,"checking log out button dispayed "+"<br>");
        Reporter.log("checking log out button dispayed "+"<br>");
        return logOutButton.isDisplayed();
    }
    public  void clickOnDepositLink(){
        CustomListeners.node.log(Status.PASS,"click on deposit "+"<br>");
        Reporter.log("click on deposit "+"<br>");
        clickOnElement(deposit);
    }
    public void clickOnWithdrow(){
        CustomListeners.node.log(Status.PASS,"click on Withdrow"+"<br>");
        Reporter.log("click on Withdrow"+"<br>");
        clickOnElement(withDrow);
    }

}