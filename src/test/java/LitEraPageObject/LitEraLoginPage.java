package LitEraPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AMogilnikov on 20.02.2017.
 */
public class LitEraLoginPage {
    private WebDriver driver;

    @FindBy(id="loginform-login")
    private WebElement textInput;
    @FindBy(id="loginform-password")
    private WebElement  passwordInput;
    @FindBy(name="register-button")
    private WebElement  submitButton;

    public LitEraLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterLogin(String login){
        textInput.sendKeys(login);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void submit(){
        submitButton.click();
    }
}
