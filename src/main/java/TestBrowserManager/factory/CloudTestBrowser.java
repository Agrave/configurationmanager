package TestBrowserManager.factory;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.BrowserType;
import TestBrowserManager.api.TestBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class CloudTestBrowser implements TestBrowserFactory {
    public static final String USERNAME = "agrave";
    public static final String ACCESS_KEY = "9fd32668-4ee1-45ab-a717-aee257f8c68c";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    DesiredCapabilities capabilities;
    URL seleniumServerURL;

    @Override
    public WebDriver create() {
        String browserName = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType = BrowserType.valueOf(browserName);

        switch (browserType) {
            case CHROME:
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "Windows 10");
                capabilities.setCapability("version", "49.0");
                break;
            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("platform", "Windows 10");
                capabilities.setCapability("version", "40.0");
                break;
            case EDGE:
                capabilities = DesiredCapabilities.edge();
                capabilities.setCapability("platform", "Windows 10");
                capabilities.setCapability("version", "13.10586");
                break;
            case IE:
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("platform", "Windows 10");
                capabilities.setCapability("version", "11.103");
                break;
            case OPERA:
            case SAFARI:
                capabilities = DesiredCapabilities.safari();
                capabilities.setCapability("platform", "macOS 10.12");
                capabilities.setCapability("version", "10.0");
                break;

            default:
                return null;
        }

        try {
            seleniumServerURL = new URL(URL);
        } catch (Exception e) {
            throw new NullPointerException("fail URL");
        }
        return new RemoteWebDriver(seleniumServerURL, capabilities);

    }
}