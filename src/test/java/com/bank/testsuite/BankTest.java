package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomersPage customersPage;
    CustomerLoginPage customerLoginPage;
    AddCustomerPage addCustomerPage;
    WithdrowAccountPage withdrowAccountPage;
    DepositAccountPage depositAccountPage;;
    OpenAccountPage openAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        addCustomerPage = new AddCustomerPage();
        depositAccountPage = new DepositAccountPage();
        openAccountPage = new OpenAccountPage();
        withdrowAccountPage = new WithdrowAccountPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnManagerLoginLink();
        bankManagerLoginPage.clickOnAddCustomerButton();
        addCustomerPage.enterFirstName("Jalpa");
        addCustomerPage.enterLastName("nakrani");
        addCustomerPage.enterPostCode("365601");
        addCustomerPage.clickOnAddCustomerButton();
        String expectedMessage = "Customer added successfully";
        String actualmessage =addCustomerPage.getAlertMessage();
        Assert.assertTrue(actualmessage.contains(expectedMessage),"displayed message is wrong");
        addCustomerPage.acceptAlertPopUp();

    }
    @Test(groups = {"sanity", "smoke","regression"})
    public void  bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnManagerLoginLink();
        bankManagerLoginPage.clickOnOpenAccountButton();
        openAccountPage.searchCustomerfromdropdownlist("Harry Potter");
        openAccountPage.SelectCurrencyfromdropdownlist("Pound");
        openAccountPage.clickOnProcessButton();
        String actualText = openAccountPage.getTextFromPopUpWindow();
        String expactedText = "Account created successfully";
        Assert.assertTrue(actualText.contains("Account created successfully"));
        openAccountPage.acceptPopUp();
    }
    @Test(groups = {"smoke","regression"})
    public void customerShouldLoginAndLogoutSuceessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourname("Harry Potter");
        customerLoginPage.clickOnLoginLink();
        softAssert.assertTrue(customersPage.customerLogOutButtonIsDisplayed());
        customersPage.clickOnLOgOut();
        softAssert.assertTrue(customerLoginPage.getYourNameText().contains("Your Name"));
        softAssert.assertAll();
    }
    @Test(groups = {"smoke", "regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourname("Harry Potter");
        customerLoginPage.clickOnLoginLink();
        customersPage.clickOnDepositLink();
        depositAccountPage.enterAmount("100");
        depositAccountPage.submitDeposit();
        Assert.assertTrue(depositAccountPage.getSuccessfullDepositText().contains("Deposit Successful"));
    }

    @Test(groups = {"smoke", "regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourname("Harry Potter");
        customerLoginPage.clickOnLoginLink();
        customersPage.clickOnWithdrow();
        withdrowAccountPage.enterAmount("50");
        withdrowAccountPage.clickOnWithdrow();
        String actualText = withdrowAccountPage.getSuccessFullyWithdrowText();
        String expactedText = "Transaction Successful";
        Assert.assertEquals(actualText, expactedText, "displayed message is wrong ");
    }

}
