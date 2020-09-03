package com.cucumber.hooks;

import static com.cucumber.driver.DriverManager.setupDriver;

import com.cucumber.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {
    @Before("@chrome")
    public void setupDriverChrome() { setupDriver("chrome"); }
    @Before("@firefox")
    public void setupDriverFirefox() { setupDriver("firefox"); }
    @Before("@safari")
    public void setupDriverSafari() { setupDriver("safari"); }
    @Before("@ie")
    public void setupDriverIE() { setupDriver("ie"); }

    @After()
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
