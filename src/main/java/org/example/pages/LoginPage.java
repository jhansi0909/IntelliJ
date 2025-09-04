package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By loginButton   = By.id("kc-login");
    public By findCourse = By.xpath("//p[text()='Find Courses']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isFindCoursePageDisplayed() {
        if(driver.findElement(findCourse).isDisplayed()){
            return true;
        }
        return false;
    }
}
