package org.example.tests;

import org.example.base.BaseClass;
import org.example.pages.LoginPage;
import org.example.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void testValidLogin() {
        // Get credentials from config.properties
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);
        // Perform login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Just a check log (replace with real assertion later)
        System.out.println("Login test executed successfully!");
        // Locate the element and get its text
        String actualText = driver.findElement(loginPage.findCourse).getText().trim();
        System.out.println("Page text is: '" + actualText + "'");

        Assert.assertTrue(loginPage.isFindCoursePageDisplayed());
        Assert.assertEquals(actualText, "Find Courses", "Find Courses text not displayed correctly!");
    }
}
