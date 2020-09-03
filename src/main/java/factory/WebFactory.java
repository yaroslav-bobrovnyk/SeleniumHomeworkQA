package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebFactory {
    private static Logger logger = LogManager.getLogger(WebFactory.class);

    public enum Browsers{
        CHROME,
        FIREFOX,
        SAFARI,
        IE
    }

    public static WebDriver create(Browsers browsers){
        switch (browsers){
            case IE: {
                WebDriverManager.getInstance(InternetExplorerDriver.class).setup();
                logger.info("Driver IE was up");
                return new InternetExplorerDriver();
            }
            case CHROME: {
                WebDriverManager.getInstance(ChromeDriver.class).setup();
                logger.info("Driver Chrome was up");
                return new ChromeDriver();
            }
            case SAFARI: {
                WebDriverManager.getInstance(SafariDriver.class).setup();
                logger.info("Driver Safari was up");
                return new SafariDriver();
            }
            case FIREFOX: {
                WebDriverManager.getInstance(FirefoxDriver.class).setup();
                logger.info("Driver Firefox was up");
                return new FirefoxDriver();
            }
            default:
                return null;
        }
    }
}
