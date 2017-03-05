package web;

import ConfigurationManager.ConfigurationManager;
import web.PageObject.LitEra.LitEraLoginPage;
import web.PageObject.LitEra.LoginPopup;
import web.PageObject.LitEra.MainPage;
import TestBrowserManager.DefaultTestBrowserManager;
import TestBrowserManager.api.TestBrowserManager;
import TestLogger.FileTestLogger;
import TestLogger.TestLogger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by AMogilnikov on 19.02.2017.
 */
public class LitEraTest {
    private final static String email = "artem.mogilnikov@gmail.com";
    private final static String password = "fhvfutljy";
    private final static String userName = "AGRAVE";
    private WebDriver browser;
    private static TestBrowserManager manager;
    private static TestLogger logger;
    private WebDriverWait wait;

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
        wait = new WebDriverWait(browser, 20);
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

    void doLogin(String logMethod) throws Exception {

        browser.get("https://lit-era.com/");
        logger.log("URL opend");

        MainPage page = new MainPage(browser);
        page.loginButton().click();
        logger.log("Login Button found");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-dialog")));
        LoginPopup loginPopup = new LoginPopup(browser.findElements(By.className("modal-dialog")).get(2));
        wait.until(ExpectedConditions.elementToBeClickable(loginPopup.viaPhoneOrEmailButton()));
        switch (logMethod) {
            case "facebook":
                loginPopup.viaFacebookButon().click();
                break;
            case "phoneoremail":
            default:
                loginPopup.viaPhoneOrEmailButton().click();
                LitEraLoginPage litEraLoginPage=new LitEraLoginPage(browser);
                litEraLoginPage.enterLogin(email);
                litEraLoginPage.enterPassword(password);
                litEraLoginPage.submit();

        }
    }

    @Test
    public void LoginViaEmailTest() throws Exception {
        logger.log("test login lit-era.com start");
        doLogin("phoneoremail");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("authed")));
        Assert.assertTrue(true);
        Thread.sleep(2_000);
    }
}