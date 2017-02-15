package TestBrowserManager.factory;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.BrowserType;
import TestBrowserManager.api.TestBrowserFactory;
import org.openqa.selenium.WebDriver;


public class CloudTestBrowser implements TestBrowserFactory {
    @Override
    public WebDriver create() {
        String browserName = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType=BrowserType.valueOf(browserName);
        switch (browserType) {
            case CHROME:
            case FIREFOX:
            case EDGE:
            case IE:
            case OPERA:
            case SAFARI:
            default:
                return null;
        }
    }
}