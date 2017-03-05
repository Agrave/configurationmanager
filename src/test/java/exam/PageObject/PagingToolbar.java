package exam.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 05.03.2017.
 */
public class PagingToolbar {
    WebElement element;

    public PagingToolbar(WebElement element) {
        this.element = element;
    }

    public void buttonAddClick(){
        element.findElement(By.cssSelector("button[data-qtip='Add']")).click();
    }

    public void buttonAddInFormClick(){
        element.findElement(By.cssSelector("button[data-qtip='Add in form']")).click();

    }

    public void buttonDeleteClick(){
        element.findElement(By.cssSelector("button[data-qtip='Delete']")).click();

    }

    public void buttonRefreshClick(){
        element.findElement(By.cssSelector("button[data-qtip='Refresh']")).click();

    }

    public void buttonApplyClick(){
        element.findElement(By.cssSelector("button[data-qtip='Apply']")).click();

    }
}
