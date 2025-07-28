package com.automation.e2etests.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for reading configuration properties from a file.
 * This class loads properties from a predefined configuration file
 * and provides access to its values.
 */
public class ConfigFileReader { 

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configs/env-config.properties";

    /**
     * Constructor that initializes the configuration file reader.
     * It loads properties from the specified file and handles exceptions appropriately.
     */
    public ConfigFileReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            System.err.println("Configuration file not found: " + e.getMessage());
            throw new RuntimeException("Configuration file not found at: " + propertyFilePath);
        } catch (IOException e) {
            System.err.println("Error while loading configuration file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error while closing the configuration file: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Retrieves the path of the WebDriver executable.
     *
     * @return the WebDriver path as a string
     * @throws RuntimeException if the property is not found in the configuration file
     */
    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) {
            return driverPath;
        } else {
            throw new RuntimeException("driverPath is not specified in the configuration file.");
        }
    }

    /**
     * Retrieves the value of a specified property from the configuration file.
     *
     * @param propertyKey the key of the property to retrieve
     * @return the property value as a string
     * @throws RuntimeException if the property is not found in the configuration file
     */
    public String getProperty(String propertyKey) {
        String propertyValue = properties.getProperty(propertyKey);
        if (propertyValue != null) {
            return propertyValue;
        } else {
            throw new RuntimeException(propertyKey + " is not specified in the configuration file.");
        }
    }
} 
