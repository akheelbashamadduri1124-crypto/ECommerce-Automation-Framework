package com.ecommerce.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {

        try (InputStream inputStream =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config/config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "Configuration file not found: config/config.properties");
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load configuration file.", e);
        }
    }

    public String getProperty(String key) {
    	
    	String systemProperty = System.getProperty(key);

        //String value = properties.getProperty(key);

        if (systemProperty != null && ! systemProperty.trim().isEmpty()) {
            return systemProperty;
        }

        return properties.getProperty(key);
    }
}