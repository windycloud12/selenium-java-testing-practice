package common.tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;

    public BaseTest() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions ops = new ChromeOptions();
//        ops.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver237.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeSuite
    private void allSetUp(){

    }


    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }
}
