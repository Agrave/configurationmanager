package exam;

import TestBrowserManager.DefaultTestBrowserManager;
import TestBrowserManager.api.TestBrowserManager;
import TestLogger.StdTestLogger;
import TestLogger.TestLogger;
import exam.PageObject.HomePage;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class AutotesttaskHerokuappTest {
    private WebDriver driver;
    private static TestBrowserManager manager;
    private TestLogger logger;
    private final String bugName = "automatic bug";
    private final String bugDescription = "created by agrave tm";


    @BeforeClass
    public static void setUpOnce() {
        manager = new DefaultTestBrowserManager();
    }

    @Before
    public void setUp() {
        driver = manager.getTestBrowser();
        logger = new StdTestLogger();
    }

    @After
    public void tearDown() {
        HomePage page = new HomePage(driver);
        page = page.deleteBugByName(bugName);
        manager.destroyTestBrowser(driver);
        logger.log("зачистка закончена");

    }

    @AfterClass
    public static void clear() {

    }

    //    @Ignore
    @Test
    public void firstBugPresent() {
        logger.log("тест firstBugPresent");
        driver.get("http://autotesttask.herokuapp.com/");
        HomePage page = new HomePage(driver);
        Assert.assertTrue(page.ifPresent("First Bug"));
        logger.log("тест закончен");
    }

    //    @Ignore
    @Test
    public void addBugWithAddInFormButton() {
        logger.log("тест addBugWithAddInFormButton");
        String name = bugName;
        String description = bugDescription;
        driver.get("http://autotesttask.herokuapp.com/");
        HomePage page = new HomePage(driver);

        page = page.addBugViaForm(name, description);
        logger.log("bug added");

        String actual = page.getBugByName(name).getName();
        logger.log("bug found");

        Assert.assertEquals(name, actual);
        logger.log("тест закончен");
    }

    //    @Ignore
    @Test
    public void addBugWithAddButton() {
        logger.log("тест addBugWithAddButton");
        String name = bugName;
        String description = bugDescription;
        driver.get("http://autotesttask.herokuapp.com/");
        HomePage page = new HomePage(driver);

        page = page.addBugViaAddButton(name, description);
        logger.log("bug added");

        String actual = page.getBugByName(name).getName();
        logger.log("bug found");

        Assert.assertEquals(name, actual);
        logger.log("тест закончен");
    }

}
