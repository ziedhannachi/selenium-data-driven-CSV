/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import util.Setup;

/**
 * Class DataDrivenTestingUsingCSVPage Page Factory
 */
public class DataDrivenTestingUsingCSVPage
{

    /** account list. */
    @FindBy(how = How.ID, using = "nav-link-accountList")
    private WebElement accountList;

    /** create account submit. */
    @FindBy(how = How.ID, using = "createAccountSubmit")
    private WebElement createAccountSubmit;

    /** customer name. */
    @FindBy(how = How.ID, using = "ap_customer_name")
    private WebElement customer_name;

    /** ap email. */
    @FindBy(how = How.ID, using = "ap_email")
    private WebElement ap_email;

    /** ap password. */
    @FindBy(how = How.ID, using = "ap_password")
    private WebElement ap_password;

    /** password check. */
    @FindBy(how = How.ID, using = "ap_password_check")
    private WebElement password_check;

    /** ap continue. */
    @FindBy(how = How.ID, using = "continue")
    private WebElement ap_continue;

    /**
     * Instanciation de data driven testing using CSV page.
     */
    public DataDrivenTestingUsingCSVPage()
    {
        super();
        PageFactory.initElements(Setup.getDriver(), this);
    }

    /**
     * methode Creates the account.
     */
    public void createAccount()
    {
        accountList.click();
        createAccountSubmit.click();
    }

    /**
     * methode Fill name.
     *
     * @param name
     */
    public void fillName(String name)
    {
        customer_name.clear();
        customer_name.sendKeys(name);
    }

    /**
     * methode Fill email.
     *
     * @param email
     */
    public void fillEmail(String email)
    {
        ap_email.clear();
        ap_email.sendKeys(email);
    }

    /**
     * methode Fill password.
     *
     * @param password
     */
    public void fillPassword(String password)
    {
        ap_password.clear();
        ap_password.sendKeys(password);
    }

    /**
     * methode Fill password check.
     *
     * @param passwordCheck 
     */
    public void fillPasswordCheck(String passwordCheck)
    {
        password_check.clear();
        password_check.sendKeys(passwordCheck);
    }
    
    /**
     * methode Click on continue.
     */
    public void clickOnContinue()
    {
        ap_continue.click();
    }

}
