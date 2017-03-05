package web.PageObject.ItEbooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class SearchResultPage {
    private WebDriver driver;
    List<BookItem> searchResult=new ArrayList<>();
    private WebElement nextPageLink;


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        try {
            nextPageLink = driver.findElement(By.className("page_num"))
                    .findElement(By.tagName("a"));
        } catch (Exception e) {
            nextPageLink = null;
        }
        List<WebElement> books = driver.findElement(By.cssSelector("table[width='100%']"))
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));
        for (WebElement b : books) {
            searchResult.add(new BookItem(b));
        }

    }

    public boolean ifExist(String byTitle) throws Exception {
        for (BookItem b : searchResult) {
            if (b.title().contains(byTitle)) return true;
        }
        return false;
    }

    public BookItem getBookItem(String title){
        for (BookItem b : searchResult) {
            if (b.title().equals(title)) return b;
        }
        return null;
    }

    public void goNext(){
        nextPageLink.click();
    }


}


