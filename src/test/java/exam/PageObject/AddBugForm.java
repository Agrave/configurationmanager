package exam.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 05.03.2017.
 */
public class AddBugForm {
    private WebElement addBugForm;

    public AddBugForm(WebElement addBugForm) {
        this.addBugForm = addBugForm;
    }

    public void enterName(String name){
        WebElement input=addBugForm.findElement(By.cssSelector("input[name='name']"));
        input.clear();
        input.sendKeys(name);
    }

    public void enterDescription(String description){
        WebElement input=addBugForm.findElement(By.cssSelector("textarea"));

        input.clear();
        input.sendKeys(description);

    }

    public void submit(){
        addBugForm.findElement(By.cssSelector("button[data-qtip='OK']")).click();
    }
}
