package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;


    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;


    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement PostCodeField;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement AddCustomerButton;

    public void enterFirstName(String firstname){
        Reporter.log("Enter first Name"+firstname+firstNameField.toString()+"<br>");
        CustomListeners.node.log(Status.PASS,"Enter first Name"+firstname+firstNameField.toString()+"<br>" );
        sendTextToElement(firstNameField,firstname);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
         CustomListeners.node.log(Status.PASS, "Enter lastname : '" + lastName + "' to lastName field");
        Reporter.log("Enter lastname : '" + lastName + "' to lastName field" + "<br>");
    }

    public void enterPostCode(String PostCode) {
        sendTextToElement(PostCodeField, PostCode);
          CustomListeners.node.log(Status.PASS, "Enter PostCode : '" + PostCode + "' to postcode field");
        Reporter.log("Enter PostCode : '" + PostCode + "' to postcode field" + "<br>");
    }

    public void clickOnAddCustomerButton() {
        CustomListeners.node.log(Status.PASS, "click On Add Customer Button : " + AddCustomerButton.getText());
        Reporter.log("Clicking on Add Customer Button " + AddCustomerButton.getText() + "<br>");
        clickOnElement(AddCustomerButton);
    }

    public String getAlertMessage() {
        Reporter.log("get text from pop up window " + "<br>");
        CustomListeners.node.log(Status.PASS, "get text from pop up window " + "<br>");
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlertPopUp() {
        Reporter.log("closing popUP box" + "<br>");
        CustomListeners.node.log(Status.PASS, "closing popUP box" + "<br>");
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}