package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTwoProductToCart {
    JavascriptExecutor js;

    public AddTwoProductToCart(){
        WebDriver driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement btnAddProduct1;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement btnAddProduct2;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement btnCart;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartImageValueItem;

    public void addToCart(){
        btnAddProduct1.click();
        btnAddProduct2.click();
        btnCart.click();
    }

    public void addTwoProductToCart() {
    }

    public byte[] getTextProductInCartList() {
        return new byte[0];
    }

}
