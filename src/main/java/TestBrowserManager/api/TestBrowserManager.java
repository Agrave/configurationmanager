package TestBrowserManager.api;

import org.openqa.selenium.WebDriver;

/**
 *
 */
public interface TestBrowserManager {
    WebDriver getTestBrowser();
    void destroyTestBrowser(WebDriver testBrowser);
}
