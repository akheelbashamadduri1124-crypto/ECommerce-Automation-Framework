package com.ecommerce.retry;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ecommerce.utilities.LogManager;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger =
            LogManager.getLogger(RetryAnalyzer.class);

    private int retryCount = 0;

    private static final int MAX_RETRY_COUNT = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRY_COUNT) {

            retryCount++;

            String testName =
                    result.getMethod().getMethodName();

            logger.warn(
                    "Retrying test: {} | Attempt: {}/{}",
                    testName,
                    retryCount,
                    MAX_RETRY_COUNT);

            return true;
        }

        return false;
    }
}