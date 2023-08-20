package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage() {
        WebDriver driver = DriverSingleton.getDriver ();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement btnCheckout;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement fieldFirstName;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement fieldLastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement fieldPostalCode;
    @FindBy(xpath = "//div[@class='error-message-container error']")
    WebElement errorMessage;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnContinue;
    @FindBy(xpath = "//button[@id='finish']")
    WebElement btnFinish;
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
    WebElement textSuccessCheckout;

    public void checkout(String firstName, String lastName, String postalCode){
        try {
            btnCheckout.click();
        }catch(Exception ignored){}
        try {
            fieldFirstName.sendKeys(firstName);
            fieldLastName.sendKeys(lastName);
            fieldPostalCode.sendKeys(postalCode);
            btnContinue.click();
            btnFinish.click();
        }catch (Exception ignored){}
    }
    public String getErrorMessage(){ // method untuk mendapatkan text error message di your information page
        return errorMessage.getText();
    }

}
