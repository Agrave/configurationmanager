package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;


public class SeleniumUtils {
    private static String curentWindow;

    public static void switchToWindow(WebDriver browser, String windowTitle) {
        curentWindow = browser.getWindowHandle();
        Set<String> windows = browser.getWindowHandles();

        for (String w : windows) {
            browser.switchTo().window(w);
            if (browser.getTitle().contains(windowTitle)) return;
        }
    }

    public static void switchToParentWindow(WebDriver browser){
        browser.switchTo().window(curentWindow);
    }


}
