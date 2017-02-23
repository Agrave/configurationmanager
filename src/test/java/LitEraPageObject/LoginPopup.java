package LitEraPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by AMogilnikov on 20.02.2017.
 */
public class LoginPopup {
    private WebElement popup;

    public LoginPopup(WebElement element) {
        popup = element;

    }

    public WebElement viaFacebookButon() {
        return popup.findElements(By.tagName("a")).get(0);
    }

    public WebElement viaVKButton() {
        return popup.findElements(By.tagName("a")).get(1);
    }

    public WebElement viaOdnoklasnikiButton() {
        return popup.findElements(By.tagName("a")).get(2);
    }

    public WebElement viaPhoneOrEmailButton() {
        return popup.findElements(By.tagName("a")).get(3);
    }
}
