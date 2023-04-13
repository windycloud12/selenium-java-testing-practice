package common.pages;

import org.openqa.selenium.WebDriver;

public class BasePage<T extends BasePage<T>> {
    protected WebDriver webDriver;

    public BasePage(WebDriver driver){
        this.webDriver = driver;

    }

    public BasePage loadPage(String url){
        webDriver.get(url);
        return this;
    }
}
