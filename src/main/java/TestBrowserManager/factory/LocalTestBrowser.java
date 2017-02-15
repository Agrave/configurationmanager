package TestBrowserManager.factory;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.api.BrowserType;
import TestBrowserManager.api.TestBrowserFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * WebDriwers binaries settings
 * System.setProperty("webdriver.chrome.driver", "/absolute/path/to/binary/chromedriver");
 * System.setProperty("webdriver.opera.driver", "/absolute/path/to/binary/operadriver");
 * System.setProperty("webdriver.ie.driver", "/absolute/path/to/binary/IEDriverServer.exe");
 * System.setProperty("webdriver.edge.driver", "/absolute/path/to/binary/MicrosoftWebDriver.exe");
 * System.setProperty("phantomjs.binary.path", "/absolute/path/to/binary/phantomjs");
 * System.setProperty("webdriver.gecko.driver", "/absolute/path/to/binary/geckodriver");
 */
public class LocalTestBrowser implements TestBrowserFactory {
    private final static String webDriversPath="src\\main\\resources\\WebDriverBin\\";
    @Override
    public WebDriver create() {
        String browserName = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType=BrowserType.valueOf(browserName);
        DesiredCapabilities capabilities;
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", webDriversPath+"chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                // work with FireFox 46.9 or lower version
                return new FirefoxDriver();
            case EDGE:
                System.setProperty("webdriver.edge.driver", webDriversPath+"MicrosoftWebDriver.exe");
                capabilities=DesiredCapabilities.edge();

                return new EdgeDriver(capabilities);
            case IE:
                /*
                * To avoid problem with lost connection to browser instance add keys to windows registr
                * Win10 x64
                *[HKEY_LOCAL_MACHINE\SOFTWARE\WOW6432Node\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_DISABLE_INTERNAL_SECURITY_MANAGER]
                * "iexplore.exe"=dword:00000001
                * HKEY_LOCAL_MACHINE\SOFTWARE\Wow6432Node\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_BFCACHE
                * "iexplore.exe"=dword:00000000
                */
                System.setProperty("webdriver.ie.driver", webDriversPath+"IEDriverServer.exe");
                capabilities=DesiredCapabilities.internetExplorer();
                capabilities.setCapability("ie.ensureCleanSession", true);
                capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS,true);
                //Magic - error without next string. Read more http://stackoverflow.com/questions/31134408/unable-to-find-element-on-closed-window-on-ie-11-working-with-selenium
                capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.bing.com/");
                return new InternetExplorerDriver(capabilities);
            case OPERA:
            case SAFARI:
            default:
                return null;
        }

    }
}
