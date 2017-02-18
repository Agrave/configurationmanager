import ConfigurationManager.ConfigurationManager;
import org.junit.*;
import utils.JVMEnvironment;

public class ConfigurationManagerTest {
    private ConfigurationManager manager;
    private String curTestBrowser;
    private String curTestEnviroment;

    @Test
    public void SingletonTest(){
        ConfigurationManager expected=ConfigurationManager.getInstance();
        ConfigurationManager actual=ConfigurationManager.getInstance();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBrowserTest(){
        JVMEnvironment.setenv(ConfigurationManager.TEST_BROWSER,"ie");
        String actual=ConfigurationManager.getInstance().getTestBrowser();
        Assert.assertEquals("ie", actual);
    }
    @Test
    public void getEnviromentTest(){
        JVMEnvironment.setenv(ConfigurationManager.TEST_ENVIRONMENT,"cloud");
        String actual=ConfigurationManager.getInstance().getTestEnvironment();
        Assert.assertEquals("cloud", actual);
    }
    @Test
    public void getDefaultBrowserTest(){
        JVMEnvironment.setenv(ConfigurationManager.TEST_BROWSER,null);
        String actual=ConfigurationManager.getInstance().getTestBrowser();
        Assert.assertEquals("chrome", actual);
    }
    @Test
    public void getDefaultEnviromentTest() {
        JVMEnvironment.setenv(ConfigurationManager.TEST_ENVIRONMENT, null);
        String actual = ConfigurationManager.getInstance().getTestEnvironment();
        Assert.assertEquals("local", actual);
    }


}
