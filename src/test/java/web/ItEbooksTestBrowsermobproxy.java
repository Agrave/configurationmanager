package web;

import web.PageObject.ItEbooks.HomePage;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.junit.*;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileOutputStream;

public class ItEbooksTestBrowsermobproxy  {
    static Proxy proxy;
    static ProxyServer server;
    WebDriver browser;
    private final static String webDriversPath="src\\main\\resources\\WebDriverBin\\";

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", webDriversPath+"chromedriver.exe");
        server =new ProxyServer(8080);
    server.start();
    proxy = server.seleniumProxy();
    }

    @Before
    public void createNewHar() {
        server.newHar("http://it-ebooks.info/");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--proxy-server=localhost:"
                + server.getPort());
        browser = new ChromeDriver(option);

    }
    @Ignore
    @Test
    public void topLabelTest() {
        browser.get("http://it-ebooks.info/");
        HomePage page = new HomePage(browser);
        String actual = page.TopDownloadLabel().getText();
        Assert.assertEquals("Top Download eBooks", actual);
    }

    @Test
    public void lastUploadTest() {
        browser.get("http://it-ebooks.info/");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HomePage page = new HomePage(browser);
        String actual = page.LastUploadLabel().getText();
        Assert.assertEquals("Last Upload eBooks", actual);
    }

    @After
    public void tearDown() throws Exception {
        browser.quit();
        Har har = server.getHar();
        File file = new File("target\\custom-logs\\"
                + har.getLog().getBrowser().getName() + ".har");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        try {
            har.writeTo(fos);
        }
        finally {
            fos.close();
        }
    }

    @AfterClass
    public static void clear() throws Exception {
        server.stop();

    }

}
