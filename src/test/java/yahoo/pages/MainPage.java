package yahoo.pages;

import common.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage<MainPage> {

    @FindBy(xpath = "//div[@id='applet_p_50000313']/div/div[contains(@class,'tabs-header')]/ul[contains(@class,'tabs-list')]/li")
    private List<WebElement> newsTabs;

    @FindBy(xpath = "//div[@id='applet_p_50000313']//ul[contains(@class,'panels')]/li")
    private List<WebElement> newsPanels;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public int getNumberOfTabs() {
        return newsTabs.size();
    }

    public int getNumberOfPanels(){
        return newsPanels.size();
    }

    public List<Integer> getNumberOfImageLinkInPanel() {
        List<Integer> numOfImageLinks = new ArrayList<Integer>();

        for(WebElement ele : newsPanels) {
            numOfImageLinks.add(ele.findElements(By.xpath("./div[contains(@id, '-content')]/div/div/ul//a")).size());
        }
        return numOfImageLinks;
    }

    public List<Integer> getNumberOfTextLinkInPanel() {
        List<Integer> numOfImageLinks = new ArrayList<Integer>();

        for(WebElement ele : newsPanels) {
            numOfImageLinks.add(ele.findElements(By.xpath("./div[contains(@id, '-content')]/div/ul//a")).size());
        }
        return numOfImageLinks;
    }
}
