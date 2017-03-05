package exam;

import TestBrowserManager.api.TestBrowserManager;
import TestBrowserManager.DefaultTestBrowserManager;
import TestLogger.TestLogger;
import TestLogger.StdTestLogger;
import exam.PageObject.HomePage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class AutotesttaskHerokuappTest {
    private WebDriver driver;
    private static TestBrowserManager manager;
    private TestLogger logger;

    @BeforeClass
    public static void setUpOnce(){
        manager=new DefaultTestBrowserManager();
    }
    @Before
    public void setUp(){
        driver =manager.getTestBrowser();
        logger = new StdTestLogger();
    }

    @After
    public void tearDown(){
        logger.log("зачистка начата");
        HomePage  page =new HomePage(driver);
        page=page.deleteBugByName("second test bug");
        manager.destroyTestBrowser(driver);
        logger.log("зачистка закончена");

    }
    @AfterClass
    public static void clear(){

    }
//    @Ignore
    @Test
    public void firstBugPresent(){
        driver.get("http://autotesttask.herokuapp.com/");
        HomePage  page =new HomePage(driver);
        Assert.assertTrue(page.ifPresent("First Bug"));
    }
//    @Ignore
    @Test
    public void addBugWithAddInFormButton(){
        logger.log("тест начат");
        String name ="second test bug";
        String description= "created by agrave tm";
        driver.get("http://autotesttask.herokuapp.com/");
        HomePage  page =new HomePage(driver);
        page = page.addBugViaForm(name,description);
        logger.log("bug added");
        String actual=page.getBugByName(name).getName();
        logger.log("bug found");
        Assert.assertEquals(name,actual);

        logger.log("тест закончен");
    }

//    @Ignore
    @Test
    public void addBugWithAddButton(){
        logger.log("тест начат");
        String name ="second test bug";
        String description= "created by agrave tm";
        driver.get("http://autotesttask.herokuapp.com/");
        HomePage  page =new HomePage(driver);
        page = page.addBugViaAddButton(name,description);
        logger.log("bug added");
        String actual=page.getBugByName(name).getName();
        logger.log("bug found");
        Assert.assertEquals(name,actual);

        logger.log("тест закончен");
    }

}
