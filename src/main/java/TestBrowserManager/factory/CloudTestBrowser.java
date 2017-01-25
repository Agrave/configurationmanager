package TestBrowserManager.factory;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.BrowserType;
import TestBrowserManager.api.TestBrowserFactory;


public class CloudTestBrowser implements TestBrowserFactory {
    @Override
    public String create() {
        String browserName = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType=BrowserType.valueOf(browserName);
        switch (browserType) {
            case CHROME:
                return "Cloud Google Chrome";
            case FIREFOX:
                return "Cloud Firefox";
            case EDGE:
                return "Cloud Edge";
            case IE:
                return "Cloud IE";
            case OPERA:
                return "Cloud Opera";
            case SAFARI:
                return "Cloud Safari";
            default:
                return null;
        }
    }
}