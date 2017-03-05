package web;

import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.DefaultTestBrowserManager;
import TestBrowserManager.api.TestBrowserManager;
import TestLogger.FileTestLogger;
import TestLogger.TestLogger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class YasinskiiTest {
    private final static String email = "agrave18@gmail.com";
    private final static String password = "fhvfutljy";
    private final static String userName = "AGRAVE";
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

    void doLogin() throws Exception {
        WebElement curentElement;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://yasinskii.ru/");
        logger.log("URL opend");

        browser.findElement(By.cssSelector("a[href='/admin/login?ref=%2F']")).click();
        logger.log("Login Button found. Login");

/*
    List<WebElement> navBarList=browser
        .findElement(By.id("bs-example-navbar-collapse-1"))
        .findElements(By.tagName("a"));
    navBarList.get(4).click();
*/
        curentElement = browser.findElement(By.id("at-field-email"));
        curentElement.clear();
        curentElement.sendKeys(email);
        logger.log("email entered");

        curentElement = browser.findElement(By.id("at-field-password"));
        curentElement.clear();
        curentElement.sendKeys(password);
        logger.log("passwor entered");

        browser.findElement(By.id("at-btn")).click();
        logger.log("login done");

        if (ConfigurationManager.getInstance().getTestEnvironment()=="local") Thread.sleep(2_000);

    }
    @Ignore
    @Test
    public void LoginTest() throws Exception {
        logger.log("test login yasinskii.ru start");
        doLogin();
        String actual = browser.findElement(By.className("dropdown-toggle")).getText();
        Assert.assertTrue(actual.contains(userName.toUpperCase()));
        logger.log("test login yasinskii.ru end");
        logger.log("");

    }

}
