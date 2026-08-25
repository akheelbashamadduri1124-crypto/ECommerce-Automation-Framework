package com.ecommerce.driver;
import org.apache.logging.log4j.Logger;
import com.ecommerce.utilities.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ecommerce.config.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
	
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
        // Utility-style class. No object creation required.
    }

    public static void initializeDriver() {

        ConfigReader configReader = new ConfigReader();

        String browser = configReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(
                configReader.getProperty("headless"));

        switch (browser.toLowerCase()) {

            case "chrome":
                initializeChromeDriver(headless);
                break;

            case "edge":
                initializeEdgeDriver(headless);
                break;

            case "firefox":
                initializeFirefoxDriver(headless);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }
    }

    private static void initializeChromeDriver(boolean headless) {

        WebDriverManager.chromedriver().setup();
        

        ChromeOptions options = new ChromeOptions();
        
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-features=PasswordLeakDetection");

        if (headless) {
            options.addArguments("--headless=new");
            
            options.addArguments("--window-size=1920,1080");
        }

        DRIVER.set(new ChromeDriver(options));
        
        getDriver().manage().window().maximize();
        
        logger.info("Chrome Browser initialized.Headless{}",headless);
    }

    private static void initializeEdgeDriver(boolean headless) {

        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();

        if (headless) {
            options.addArguments("--headless=new");
        }

        DRIVER.set(new EdgeDriver(options));
        
        getDriver().manage().window().maximize();
        
        logger.info("Edge Browser initialized.Headless{}",headless);
    }

    private static void initializeFirefoxDriver(boolean headless) {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();

        if (headless) {
            options.addArguments("--headless");
        }

        DRIVER.set(new FirefoxDriver(options));
        
        getDriver().manage().window().maximize();
        
        logger.info("FireFox Browser initialized.Headless{}",headless);
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
    public static void unloadDriver() {
    	DRIVER.remove();
    }
}