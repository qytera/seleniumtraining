package dev.webtesting.eu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Mario Hanneken @ Qytera on 04.08.2017.
 * Basic class for testing the installation and setup
 */
public class SeleniumBasics {
    private WebDriver driver;

    private static final String url             = "http://selenium.webtesting.eu/";
    private static final String title           = "Selenium";
    private static final String driverFolder    = "c:\\driver\\";

    @BeforeClass
    public void setDriver(){
        System.setProperty("webdriver.gecko.driver", driverFolder + "geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", driverFolder + "chromedriver.exe");
    }

    @Test
    public void checkFirefox(){
        driver = new FirefoxDriver();
        driver.get(url);
        assertTrue(driver.getTitle().startsWith(title));
    }

    @Test
    public void checkChrome(){
        driver = new ChromeDriver();
        driver.get(url);
        assertTrue(driver.getTitle().startsWith(title));
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}
