package TestBrowserManager.factory;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.BrowserType;
import TestBrowserManager.api.TestBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BildServerTestBrowser implements TestBrowserFactory {
    @Override
    public WebDriver create() {
        String browserName = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType = BrowserType.valueOf(browserName);
        DesiredCapabilities capabilities = null;
        switch (browserType) {
            case CHROME:
                capabilities = DesiredCapabilities.chrome();
                System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
                break;
            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                break;
            case EDGE:
                capabilities = DesiredCapabilities.edge();
                break;
            case IE:
                capabilities = DesiredCapabilities.internetExplorer();
                break;
            case OPERA:
                capabilities = DesiredCapabilities.operaBlink();
                break;
            case SAFARI:
                capabilities = DesiredCapabilities.safari();
                break;
            default:
                return null;
        }
        URL seleniumServerURL;
        try {
            seleniumServerURL = new URL("http://127.0.0.1:4444/wd/hub");
        } catch (Exception e) {
            throw new NullPointerException("fail URL");
        }
        return new RemoteWebDriver(seleniumServerURL, capabilities);

    }
}
