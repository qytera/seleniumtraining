package dev.webtesting.eu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Mario Hanneken @ Qytera on 04.08.2017.
 * Bug Fix 18.12.2018
 * Basic class for testing the installation and setup
 */
public class SeleniumBasics {
    private WebDriver driver;

    private static final String url             = "http://selenium.webtesting.eu/";
    private static final String title           = "Selenium";
    private static final String driverFolder    = "c:\\Tools\\driver\\";

    @BeforeClass
    public void setDriver(){
        System.setProperty("webdriver.gecko.driver", driverFolder + "geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", driverFolder + "chromedriver.exe");
    }

    @BeforeMethod
    public void nullDriver(){
        driver = null;
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

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

    @AfterClass
    public void deInitialize(){}

}
