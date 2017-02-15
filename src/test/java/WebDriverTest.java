import ConfigurationManager.ConfigurationManager;
import TestBrowserManager.DefaultTestBrowserManager;
import TestBrowserManager.api.TestBrowserManager;
import TestLogger.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 */
public class WebDriverTest {
    private final static String email = "agrave18@gmail.com";
    private final static String password = "fhvfutljy";
    private final static String userName = "AGRAVE";
    WebDriver browser;
    TestBrowserManager manager ;
    TestLogger logger;

    @Before
    public void setUp() throws Exception {
        logger=new FileTestLogger();
        manager= new DefaultTestBrowserManager();
        browser = manager.getTestBrowser();
        logger.log("browser: "+ConfigurationManager.getInstance().getTestBrowser());
        logger.log("enviroment: "+ConfigurationManager.getInstance().getTestEnvironment());
    }

    @After
    public void clear() {
        manager.destroyTestBrowser(browser);
        manager=null;
        logger.log("FINISH");
    }

    @Test
    public void LoginTest() throws Exception{
        WebElement curentElement;

        logger.log("try to open URL");
        browser.get("http://yasinskii.ru/");
        logger.log("URL opend");

        Thread.sleep(5_000);
        logger.log("try to find Login Button");
        browser.findElement(By.cssSelector("a[href='/admin/login?ref=%2F']")).click();
        logger.log("Login Button found. Login");

/*
List<WebElement> navBarList=browser
.findElement(By.id("bs-example-navbar-collapse-1"))
.findElements(By.tagName("a"));
navBarList.get(4).click();
*/

        Thread.sleep(1_000);

        curentElement = browser.findElement(By.id("at-field-email"));
        curentElement.clear();
        curentElement.sendKeys(email);

        Thread.sleep(2_00);

        curentElement = browser.findElement(By.id("at-field-password"));
        curentElement.clear();
        curentElement.sendKeys(password);

        browser.findElement(By.id("at-btn")).click();

        Thread.sleep(5_000);

        String actual = browser.findElement(By.className("dropdown-toggle")).getText();
        System.out.println(actual);

        Assert.assertTrue(actual.contains(userName.toUpperCase()));

    }
}
