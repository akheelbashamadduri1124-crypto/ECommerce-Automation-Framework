package com.ecommerce.reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {

    private static ExtentReports extentReports;

    private ExtentReportManager() {
    }

    public static ExtentReports getExtentReports() {

        if (extentReports == null) {

            String reportPath =
                    System.getProperty("user.dir")
                            + File.separator
                            + "reports"
                            + File.separator
                            + "ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config()
                    .setDocumentTitle("E-Commerce Automation Report");

            sparkReporter.config()
                    .setReportName("E-Commerce SDET Test Report");

            extentReports =
                    new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo(
                    "Application", "SauceDemo");

            extentReports.setSystemInfo(
                    "Automation", "Selenium");

            extentReports.setSystemInfo(
                    "Framework", "TestNG");

            extentReports.setSystemInfo(
                    "Language", "Java");
        }

        return extentReports;
    }
}