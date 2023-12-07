package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class EnvHelper {
    private static final String ENV_FILE = "src/test/resources/.env_local.properties";

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(new FileInputStream(ENV_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load environment properties file: " + ENV_FILE, e);
        }
    }

    public static String getDriverPath() {
        return PROPERTIES.getProperty("driver.path");
    }

    public static String getBrowserPath() {
        return PROPERTIES.getProperty("browser.path");
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("base.url");
    }

    public static String getLoginUrl() {
        return PROPERTIES.getProperty("login.url");
    }

    public static String getSqlUrl() {
        return PROPERTIES.getProperty("sql.url");
    }

    public static String getSqlPhpUrl() {
        return PROPERTIES.getProperty("sql.php.url");
    }

    public static String getDroppableUrl() {
        return PROPERTIES.getProperty("droppable.url");
    }

    public static Duration getImplicitWaitDuration() {
        int seconds = Integer.parseInt(PROPERTIES.getProperty("implicitly.wait.seconds", "10"));
        return Duration.ofSeconds(seconds);
    }

    public static Duration getExplicitWaitDuration() {
        int seconds = Integer.parseInt(PROPERTIES.getProperty("explicit.wait.seconds", "20"));
        return Duration.ofSeconds(seconds);
    }

    public static String getUserName() {
        return PROPERTIES.getProperty("username");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("password");
    }

    public static String getUserNameDescription() {
        return PROPERTIES.getProperty("usernameDescription");
    }

    public static String getInvalidUsername() {
        return PROPERTIES.getProperty("invalid.username");
    }

    public static String getInvalidPassword() {
        return PROPERTIES.getProperty("invalid.password");
    }

    public static String getLoginSql() {
        return PROPERTIES.getProperty("login.sql");
    }

    public static String getPasswordSql() {
        return PROPERTIES.getProperty("password.sql");
    }

    public static String getChromeDriverPath() {
        return PROPERTIES.getProperty("chromeDriver.path");
    }

    public static String getGeckoDriverPath() {
        return PROPERTIES.getProperty("geckoDriver.path");
    }

    public static String getEdgeDriverPath() {
        return PROPERTIES.getProperty("edgeDriver.path");
    }

    public static String getIEDriverPath() {
        return PROPERTIES.getProperty("ieDriver.path");
    }
}