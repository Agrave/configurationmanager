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
    public static void open() {
        logger = new FileTestLogger();
        logger.log("browser: " + ConfigurationManager.getInstance().getTestBrowser());
        logger.log("enviroment: " + ConfigurationManager.getInstance().getTestEnvironment());
        manager = new DefaultTestBrowserManager();
        openSetings();
    }

    @Before
    public void setUp() throws Exception {
        browser = manager.getTestBrowser();
        setUpSettings();
    }

    @After
    public void tearDown() {
        manager.destroyTestBrowser(browser);
        tearDownSetings();
    }

    @AfterClass
    public static void clear() {
        manager = null;
        logger.log("FINISH");
        logger = null;
        clearSetings();
    }

    protected static void openSetings(){

    }
    protected static void clearSetings(){

    }
    protected void setUpSettings(){

    }
    protected void tearDownSetings(){

    }
}
