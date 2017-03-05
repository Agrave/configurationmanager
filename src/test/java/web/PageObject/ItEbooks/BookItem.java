package web.PageObject.ItEbooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class BookItem {
    private WebElement item;
    private String title;

    BookItem(WebElement item){
        this.item=item;
        title=item.findElement(By.tagName("a")).getAttribute("title");
    }

    public String title(){
        return title;
    }

//    public String description(){
//        return item.findElement(By.xpath("td[2]")).getText();
//    }

    public void goToBookPage(){
         item.findElement(By.tagName("a")).click();
    }

}
