package com.cucumber.driver;

import factory.WebFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    protected static WebDriver driver;

    public DriverManager() {
    }

    public static void setupDriver(String browser) {
        browser=browser.toUpperCase();
        driver= WebFactory.create(WebFactory.Browsers.valueOf(browser));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getWebDriver()).ifPresent(WebDriver::quit);
    }
}
