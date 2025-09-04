package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.example.utils.ConfigReader;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Load config
        ConfigReader.loadConfig();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Add implicit wait (applies to all findElement calls)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to base URL
        String baseUrl = ConfigReader.getProperty("url");
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
