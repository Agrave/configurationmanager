package ConfigurationManager;


public class ConfigurationManager {
    private static ConfigurationManager instance = null;

    public static final String TEST_BROWSER = "testBrowser";
    public static final String TEST_ENVIRONMENT = "testEnvironment";

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null)
            return new ConfigurationManager();
        return instance;
    }

    public String getTestBrowser() {
        return getEnvironmentVariable(TEST_BROWSER, "chrome");
    }

    public String getTestEnvironment() {
        return getEnvironmentVariable(TEST_ENVIRONMENT, "local");
    }

    private String getEnvironmentVariable(String variable, String defaultValue) {
        return System.getenv(variable) != null ? System.getenv(variable) : defaultValue;
    }
}