package com.ecommerce.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.LogManager;
import com.ecommerce.utilities.SeleniumUtils;

public class ProductsPage {

    private static final Logger logger =
            LogManager.getLogger(ProductsPage.class);

    private final SeleniumUtils seleniumUtils;

    private final By firstProduct =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By cartIcon =
            By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void addFirstProductToCart() {

        seleniumUtils.click(firstProduct);

        logger.info("Product added to cart: Sauce Labs Backpack");
    }

    public void openCart() {

        seleniumUtils.click(cartIcon);

        logger.info("Shopping cart opened");
    }
}