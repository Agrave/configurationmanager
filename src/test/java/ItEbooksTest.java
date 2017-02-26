import ItEbooksPageObjects.BookDetailPage;
import ItEbooksPageObjects.HomePage;
import ItEbooksPageObjects.SearchHeader;
import ItEbooksPageObjects.SearchResultPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class ItEbooksTest extends DefaultWebTest {

    @Test
    public void topLabelTest() {
        browser.get("http://it-ebooks.info/");
        HomePage page = new HomePage(browser);
        String actual = page.TopDownloadLabel().getText();
        Assert.assertEquals("Top Download eBooks", actual);
    }

    @Test
    public void lastUploadTest() {
        browser.get("http://it-ebooks.info/");
        HomePage page = new HomePage(browser);
        String actual = page.LastUploadLabel().getText();
        Assert.assertEquals("Last Upload eBooks", actual);
    }

    @Test
    public void searchJavaBookTest() throws Exception {
        String testBookTitle="Head First jQuery";
        String searchQuery="Head First";
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
        System.out.println(bookDetailPage);


        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
