package web.PageObject.ItEbooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class SearchHeader {
    private WebDriver driver;
    private WebElement searchText;
    private WebElement titleRadio;
    private WebElement searchButton;

    public SearchHeader(WebDriver driver){
        this.driver=driver;
        searchText=driver.findElement(By.id("q"));
        titleRadio =driver.findElement(By.cssSelector("input[value='title']"));
        searchButton=driver.findElement(By.cssSelector("input[type='submit'"));
    }

    public WebElement getSearchText() {
        return searchText;
    }

    public WebElement getTitleRadio() {
        return titleRadio;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
