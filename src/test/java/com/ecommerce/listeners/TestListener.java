package com.ecommerce.listeners;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.driver.DriverFactory;
import com.ecommerce.reports.ExtentReportManager;
import com.ecommerce.utilities.LogManager;
import com.ecommerce.utilities.ScreenShotUtils;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    private static final ExtentReports extentReports =
            ExtentReportManager.getExtentReports();

    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();
    
    private ExtentTest getOrCreateTest(ITestResult result) {

        ExtentTest test = extentTest.get();

        if (test == null) {

            String testName =
                    result.getMethod().getMethodName();

            Object[] parameters = result.getParameters();

            if (parameters.length > 0) {
                testName = testName
                        + " - User: "
                        + parameters[0];
            }

            test = extentReports.createTest(testName);

            extentTest.set(test);
        }

        return test;
    }
    
    
    
    

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();
        
        Object[]parameters = result.getParameters();

        if(parameters.length>0) {
        	testName = testName+"-user:"+parameters[0];
        	
        }
        ExtentTest test = extentReports.createTest(testName);
        
        extentTest.set(test);
        
        logger.info("TEST STARTED:{}",testName);
        
        test.info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        logger.info("TEST PASSED: {}", testName);

         getOrCreateTest(result).pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        logger.error("TEST FAILED: {}", testName,result.getThrowable());

         getOrCreateTest(result).fail(result.getThrowable());

        WebDriver driver =
                DriverFactory.getDriver();

        if (driver != null) {

            String screenshotPath =
                    ScreenShotUtils.captureScreenshot(
                            driver,
                            testName);

            logger.info(
                    "Screenshot captured: {}",
                    screenshotPath);

             getOrCreateTest(result).addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        logger.warn("TEST SKIPPED: {}", testName);

        getOrCreateTest(result).skip("Test skipped");
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extentReports.flush();

        logger.info(
                "Extent report generated successfully");
    }
}