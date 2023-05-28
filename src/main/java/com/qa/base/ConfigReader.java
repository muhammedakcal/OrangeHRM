package com.qa.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    /**
     * Read properties from the configuration file
     *
     * @param filePath - configuration.properties file path
     */
    public static void readProperties(String filePath) {

        try {
            FileInputStream file = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }


    /**
     * Get properties from the configutaion file
     *
     * @param key - Key data which will be retrieved
     */
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }


}
