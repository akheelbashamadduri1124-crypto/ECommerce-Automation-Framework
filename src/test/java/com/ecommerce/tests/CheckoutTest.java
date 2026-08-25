package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

 
import com.ecommerce.base.BaseClass;
import com.ecommerce.config.ConfigReader;
import com.ecommerce.driver.DriverFactory;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckOutPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.testdata.TestData;

public class CheckoutTest extends BaseClass {

    @Test(groups ={"smoke","regression"})
    public void verifyCheckout() {

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

        cartPage.clickCheckout();

        CheckOutPage checkOutPage =
                new CheckOutPage(DriverFactory.getDriver());

        checkOutPage.completeCheckoutInformation(
                "Akheel",
                "Basha",
                "560037");

        
        checkOutPage.clickFinish();
        
        String confirmationMessage =
                checkOutPage.getOrderConfirmationMessage();

        Assert.assertEquals(
                confirmationMessage,
                TestData.EXPECTED_ORDER_MESSAGE,
                "Order confirmation message was not displayed.");
        
        
        
        
    }
}