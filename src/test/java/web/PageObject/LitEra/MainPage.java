package web.PageObject.LitEra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by AMogilnikov on 20.02.2017.
 */
public class MainPage {
    private WebDriver driver;
    private WebElement loginButton;
    private WebElement regButton;

    public MainPage(WebDriver driver){
        this.driver=driver;
        WebDriverWait wait=new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-auth")));
        loginButton=driver.findElement(By.className("btn-auth"));
        regButton=driver.findElements(By.className("btn-auth")).get(1);
    }

    public WebElement loginButton(){
        return loginButton;
    }

    public WebElement regButton(){
        return regButton;
    }
}
