package com.ecommerce.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {

    private ScreenShotUtils() {
        // Utility class.
    }

    public static String captureScreenshot(
            WebDriver driver,
            String screenshotName) {

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File destination =
                new File(
                        "screenshots"
                                + File.separator
                                + screenshotName
                                + ".png");

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to save screenshot: "
                            + destination.getAbsolutePath(),
                    e);
        }

        return destination.getAbsolutePath();
    }
}