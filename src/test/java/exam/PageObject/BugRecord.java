package exam.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 05.03.2017.
 */
public class BugRecord {
    private WebElement record;

    public BugRecord(WebElement record) {
        this.record = record;
    }

    public String getName(){
//*[@id="gridview-1028"]/table/tbody/tr[2]/td[3]/div
        return record.findElement(
                By.cssSelector("td[class*='x-grid-cell-gridcolumn-1020'")).findElement(By.tagName("div")).getText();
    }

    public WebElement getElement(){
        return record;
    }

    public void select(){
        record.click();
    }
}
