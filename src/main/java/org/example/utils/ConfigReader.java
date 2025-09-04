package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Load properties once
    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get property by key
    public static String getProperty(String key) {
        if (properties == null) {
            loadConfig();  // ensure properties are loaded
        }
        return properties.getProperty(key);
    }
}
