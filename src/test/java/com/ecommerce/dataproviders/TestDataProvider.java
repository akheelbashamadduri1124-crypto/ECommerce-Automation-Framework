package com.ecommerce.dataproviders;

import org.testng.annotations.DataProvider;

import com.ecommerce.utilities.ExcelUtils;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

         return ExcelUtils.getLoginData();
    
    }
}