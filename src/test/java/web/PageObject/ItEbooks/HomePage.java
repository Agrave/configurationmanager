package web.PageObject.ItEbooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class HomePage {
    private WebDriver driver;

    private WebElement topDownloadLabel;
    private WebElement lastUploadLabel;

    public HomePage(WebDriver driver){
        this.driver=driver;
        topDownloadLabel=driver.findElement(By.cssSelector("table[class='main']"))
                .findElement(By.xpath("tbody/tr[2]/td/h2"));

        lastUploadLabel=driver.findElement(By.cssSelector("table[class='main']"))
                .findElement(By.xpath("tbody/tr[3]/td/h2"));
    }

    public WebElement TopDownloadLabel() {
        return topDownloadLabel;
    }

    public WebElement LastUploadLabel() {
        return lastUploadLabel;
    }
}
