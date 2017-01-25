package TestBrowserManager.factory;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.BrowserType;
import TestBrowserManager.api.TestBrowserFactory;

/**
 * Created by Rabot'aga on 29.12.2016.
 */
public class LocalTestBrowser implements TestBrowserFactory {
    @Override
    public String create() {
        String browserName = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType=BrowserType.valueOf(browserName);
        switch (browserType) {
            case CHROME:
                return "Local Google Chrome";
            case FIREFOX:
                return "Local Firefox";
            case EDGE:
                return "Local Edge";
            case IE:
                return "Local IE";
            case OPERA:
                return "Local Opera";
            case SAFARI:
                return "Local Safari";
            default:
                return null;
        }

    }
}
