package common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import yahoo.pages.MainPage;

public class YahooManager {
    private final WebDriver webDriver;
    private MainPage mainPage;

    public YahooManager(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage getMainPage() {
        if(mainPage == null) {
            mainPage = PageFactory.initElements(webDriver, MainPage.class);//new MainPage(webDriver);
        }
        return mainPage;
    }


}
