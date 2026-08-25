package com.ecommerce.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.LogManager;
import com.ecommerce.utilities.SeleniumUtils;

public class CartPage {

    private static final Logger logger =
            LogManager.getLogger(CartPage.class);

    private final SeleniumUtils seleniumUtils;

    private final By firstCartItem =
            By.className("inventory_item_name");

    private final By checkoutButton =
            By.id("checkout");

    private final By removeButton = By.id("remove-sauce-labs-backpack");
    
    private final By cartItems = By.className("cart_item");
    
   
    
    public CartPage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public String getFirstCartItemName() {

        String productName =
                seleniumUtils.getText(firstCartItem);

        logger.info("Cart product verified: {}", productName);

        return productName;
    }
    
    
    public void removeFirstProduct() {
    	seleniumUtils.click(removeButton);
    	
    	logger.info("Product removed from cart");
    }

    public void clickCheckout() {

        seleniumUtils.click(checkoutButton);

        logger.info("Checkout button clicked");
    }
    
    public boolean isCartEmpty() {

        boolean isEmpty =
                seleniumUtils.getElementsCount(cartItems) == 0;

        logger.info("Cart empty status: {}", isEmpty);

        return isEmpty;
    }
}