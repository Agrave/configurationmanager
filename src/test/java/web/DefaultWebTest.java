package web;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.DefaultTestBrowserManager;
import TestBrowserManager.api.TestBrowserManager;
import TestLogger.FileTestLogger;
import TestLogger.TestLogger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

/**
 * Created by AMogilnikov on 23.02.2017.
 */
public class DefaultWebTest {
    WebDriver browser;
    static TestBrowserManager manager;
    static TestLogger logger;

    @BeforeClass
    public static void runOnceSetup() {
        logger = new FileTestLogger();
        logger.log("browser: " + ConfigurationManager.getInstance().getTestBrowser());
        logger.log("enviroment: " + ConfigurationManager.getInstance().getTestEnvironment());
        manager = new DefaultTestBrowserManager();

    }

    @Before
    public void setup() throws Exception {
        browser = manager.getTestBrowser();
    }

    @After
    public void clear() {
        manager.destroyTestBrowser(browser);
    }

    @AfterClass
    public static void runOnceClear() {
        manager = null;
        logger.log("FINISH");
        logger = null;
    }


}
