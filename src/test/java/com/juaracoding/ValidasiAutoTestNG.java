package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddTwoProductToCart;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class ValidasiAutoTestNG {
    WebDriver driver;
    LoginPage login;
    AddTwoProductToCart addTwoProductToCart;
    CheckoutPage checkout;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance ("chrome");
        driver = DriverSingleton.getDriver ();
        driver.get ("https://www.saucedemo.com");
        login = new LoginPage ();
        addTwoProductToCart = new AddTwoProductToCart ();
        checkout = new CheckoutPage ();
    }

    @AfterClass
    public void finish() {
        DriverSingleton.delay ();
        DriverSingleton.closeObjectInstance ();
    }
    @Test(priority = 1)
    public void invalidLogin(){
        login.login("Admin","admin123");
        Assert.assertEquals(login.getErrorMessage(),"Epic sad-face: Username and password do not match any user in this service");
    }
    @Test(priority = 2)
    public void validLogin(){
        login.login("standard_user","secret_sauce");
        Assert.assertEquals(login.getTextLoginSuccess(),"Products");
    }
    @Test(priority = 3)
    public void addTwoProductToCart(){
        addTwoProductToCart.addTwoProductToCart();
        Assert.assertEquals(Set.of (), "2");
        Assert.assertEquals(addTwoProductToCart.getTextProductInCartList(), "Sauce Labs Backpack" +
                "Sauce Labs Bolt T-Shirt");
    }
    @Test(priority = 4)
    public void InvalidCheckout(){
        checkout.checkout("Nurul","Luthfiyah","");
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Postal Code is required");
        driver.navigate().refresh();
    }
    @Test(priority = 5)
    public void testLogout(){
        login.logout();
    }
}
