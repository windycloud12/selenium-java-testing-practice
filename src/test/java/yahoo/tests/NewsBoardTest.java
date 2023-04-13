package yahoo.tests;

import common.tests.BaseTest;
import common.utils.YahooManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class NewsBoardTest extends BaseTest {

    private YahooManager manager;
    private String url;

    @BeforeClass
    private void starUp() {
        manager = new YahooManager(webDriver);
        url = "https://yahoo.com.tw";
    }


    @Test
    public void boardFormatTest() {
        manager.getMainPage().loadPage(url);

        Assert.assertEquals(manager.getMainPage().getNumberOfTabs(), 6, "新聞頁簽數量有誤");
        Assert.assertEquals(manager.getMainPage().getNumberOfPanels(), 6, "新聞看板數量有誤");

        List<Integer> numberOfImageLinkInPanel = manager.getMainPage().getNumberOfImageLinkInPanel();
        for(int i = 0; i < numberOfImageLinkInPanel.size(); i++){
            Assert.assertTrue(numberOfImageLinkInPanel.get(i).intValue() >= 3, "新聞看板-圖片連結數量不足");
        }

        List<Integer> numberOfTextLinkInPanel = manager.getMainPage().getNumberOfTextLinkInPanel();
        for(int i = 0; i < numberOfTextLinkInPanel.size(); i++){
            Assert.assertTrue(numberOfTextLinkInPanel.get(i).intValue() >= 6, "新聞看板-文字連結數量不足");
        }
    }

}
