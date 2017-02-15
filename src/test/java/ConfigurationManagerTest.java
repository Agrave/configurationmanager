import ConfigurationManager.ConfigurationManager;
import org.junit.*;

/**
 * Created by AMogilnikov on 14.02.2017.
 */
public class ConfigurationManagerTest {
    private ConfigurationManager manager;
    private String curTestBrowser;
    private String curTestEnviroment;

    @Ignore
    @Test
    public void SingletonTest(){
        ConfigurationManager expected=ConfigurationManager.getInstance();
        Assert.assertEquals(expected, manager);
    }

    @Before
    public void setUp(){
        manager=ConfigurationManager.getInstance();
        curTestBrowser=System.getProperty(ConfigurationManager.TEST_BROWSER,"");
        curTestEnviroment=System.getProperty(ConfigurationManager.TEST_ENVIRONMENT,"");
    }
    @After
    public void clear(){
        System.setProperty(ConfigurationManager.TEST_BROWSER,curTestBrowser );
        System.setProperty(ConfigurationManager.TEST_ENVIRONMENT,curTestEnviroment);
    }
    @Test
    public void defaultBrowserTest(){
        String expected="chrome";
        System.setProperty(ConfigurationManager.TEST_BROWSER," ");
        String actual=manager.getTestBrowser();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void defaultEnviromentTest(){
        String expected="local";
        System.setProperty(ConfigurationManager.TEST_ENVIRONMENT," ");
        String actual=manager.getTestEnvironment();
        Assert.assertEquals(expected,actual);
    }

}
