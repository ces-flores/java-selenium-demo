package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.PropertiesConfiguration;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", PropertiesConfiguration.BROWSER_DRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(PropertiesConfiguration.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanTest() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
