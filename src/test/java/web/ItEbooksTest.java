package web;

import org.junit.Ignore;
import web.PageObject.ItEbooks.BookDetailPage;
import web.PageObject.ItEbooks.HomePage;
import web.PageObject.ItEbooks.SearchHeader;
import web.PageObject.ItEbooks.SearchResultPage;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class ItEbooksTest extends DefaultWebTest {
    @Ignore
    @Test
    public void topLabelTest() {
        browser.get("http://it-ebooks.info/");
        HomePage page = new HomePage(browser);
        String actual = page.TopDownloadLabel().getText();
        Assert.assertEquals("Top Download eBooks", actual);
    }

    @Ignore
    @Test
    public void lastUploadTest() {
        browser.get("http://it-ebooks.info/");
        HomePage page = new HomePage(browser);
        String actual = page.LastUploadLabel().getText();
        Assert.assertEquals("Last Upload eBooks", actual);
    }

    @Ignore
    @Test
    public void searchJavaBookTest() throws Exception {
        String testBookTitle="Functional Programming in Java";
        String searchQuery="Java";
        browser.get("http://it-ebooks.info/");
        SearchHeader page = new SearchHeader(browser);
        page.getTitleRadio().click();
        page.getSearchText().clear();
        page.getSearchText().sendKeys(searchQuery);
        page.getSearchButton().click();

        SearchResultPage searchResultPage = new SearchResultPage(browser);
        while (true){
            if (searchResultPage.ifExist(testBookTitle)){
                searchResultPage.getBookItem(testBookTitle).goToBookPage();
                break;
            }
            searchResultPage.goNext();
            searchResultPage=new SearchResultPage(browser);
        }
        BookDetailPage bookDetailPage=new BookDetailPage(browser);
        logger.log("ok");
        System.out.println(bookDetailPage);
        Assert.assertEquals(testBookTitle, bookDetailPage.title().getText());

        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(0))
                .takeScreenshot(browser);
        try {
            String scrshotFileName="target\\custom-logs\\" +"scr3.png";
            ImageIO.write(screenshot.getImage(), "PNG", new File(scrshotFileName));
        } catch (Exception e) {
        }


        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
