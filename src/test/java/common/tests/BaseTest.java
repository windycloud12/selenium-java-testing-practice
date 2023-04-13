package common.tests;

import common.listeners.LogListener;
import common.utils.LoggerManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners(LogListener.class)
public class BaseTest {
    protected WebDriver webDriver;

    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver237.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @BeforeSuite
    private void allSetUp() {

    }

    @AfterSuite
    public void tearDown() {
        webDriver.quit();
    }
}
