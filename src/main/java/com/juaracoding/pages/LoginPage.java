package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    JavascriptExecutor js;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = ( JavascriptExecutor ) driver;
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    @FindBy(xpath = "//div[@class='error-message-container error']")
    WebElement textErrorMessage;
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement btnBurger;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement btnLogout;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void logout() {
        btnBurger.click();
        btnLogout.click();
    }

    public String getErrorMessage(){ // method untuk mendapatkan text error message di login
        return textErrorMessage.getText();
    }

    public byte[] getTextLoginSuccess() {
        return new byte[0];
    }
}
