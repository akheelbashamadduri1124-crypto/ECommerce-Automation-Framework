package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.config.ConfigReader;
import com.ecommerce.driver.DriverFactory;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.testdata.TestData;

public class CartTest extends BaseClass {

    @Test(groups = { "smoke", "regression" })
    public void verifyAddProductToCart() {

        ConfigReader configReader = new ConfigReader();

        DriverFactory.getDriver().get(
                configReader.getProperty("url"));

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                configReader.getProperty("username"),
                configReader.getProperty("password"));

        ProductsPage productsPage =
                new ProductsPage(DriverFactory.getDriver());

        productsPage.addFirstProductToCart();
        productsPage.openCart();

        CartPage cartPage =
                new CartPage(DriverFactory.getDriver());

        String productName =
                cartPage.getFirstCartItemName();

        Assert.assertEquals(
                productName,
                TestData.EXPECTED_PRODUCT,
                "Expected product was not added to cart.");
    }
    
    @Test(groups = { "regression" })
    public void verifyRemoveProductFromCart() {

        ConfigReader configReader = new ConfigReader();

        DriverFactory.getDriver().get(
                configReader.getProperty("url"));

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                configReader.getProperty("username"),
                configReader.getProperty("password"));

        ProductsPage productsPage =
                new ProductsPage(DriverFactory.getDriver());

        productsPage.addFirstProductToCart();
        productsPage.openCart();

        CartPage cartPage =
                new CartPage(DriverFactory.getDriver());

        cartPage.removeFirstProduct();
        
        boolean isEmpty = cartPage.isCartEmpty();
        
        Assert.assertTrue(isEmpty,"Cart is not empty after removing the product.");
    }
    
    
    
    
    
}