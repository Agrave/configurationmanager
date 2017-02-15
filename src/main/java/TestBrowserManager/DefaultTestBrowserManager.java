package TestBrowserManager;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.Enviroment;
import TestBrowserManager.api.TestBrowserFactory;
import TestBrowserManager.api.TestBrowserManager;
import TestBrowserManager.factory.BildServerTestBrowser;
import TestBrowserManager.factory.CloudTestBrowser;
import TestBrowserManager.factory.LocalTestBrowser;
import org.openqa.selenium.WebDriver;

public class DefaultTestBrowserManager implements TestBrowserManager {

    @Override
    public WebDriver getTestBrowser() {

        String env = ConfigurationManager.getInstance().getTestEnvironment().toUpperCase();
        Enviroment enviroment= Enviroment.valueOf(env);
        TestBrowserFactory testBrowserFactory;
        switch (enviroment) {
            case CLOUD:
                testBrowserFactory = new CloudTestBrowser();
                break;
            case BIDLSERVER:
                testBrowserFactory = new BildServerTestBrowser();
                break;
            case LOCAL:
                testBrowserFactory = new LocalTestBrowser();
                break;
            default:
                return null;
        }
        return testBrowserFactory.create();


    }

    @Override
    public void destroyTestBrowser(WebDriver testBrowser) {
        if (testBrowser!=null) testBrowser.quit();

    }
}
