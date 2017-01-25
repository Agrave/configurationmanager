package TestBrowserManager.factory;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.BrowserType;
import TestBrowserManager.api.TestBrowserFactory;

public class BildServerTestBrowser implements TestBrowserFactory {
    @Override
    public String create() {
        String browserName = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType=BrowserType.valueOf(browserName);
        switch (browserType) {
            case CHROME:
                return "BildServer Google Chrome";
            case FIREFOX:
                return "BildServer Firefox";
            case EDGE:
                return "BildServer Edge";
            case IE:
                return "BildServer IE";
            case OPERA:
                return "BildServer Opera";
            case SAFARI:
                return "BildServer Safari";
            default:
                return null;
        }
    }
}
