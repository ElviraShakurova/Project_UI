package tests.base;

import helpers.EnvHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static final String GRID_URL = "http://172.25.48.1:4444";

    public static WebDriver createDriver(String browser, boolean useGrid) {
        WebDriver driver;

        if (useGrid) {
            driver = createRemoteDriver(browser);
        } else {
            driver = createLocalDriver(browser);
        }

        return driver;
    }

    private static WebDriver createRemoteDriver(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");
            capabilities.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
        } else if (browser.equalsIgnoreCase("edge")) {
            capabilities.setBrowserName("MicrosoftEdge");
            capabilities.setCapability(EdgeOptions.CAPABILITY, new EdgeOptions());
        } else if (browser.equalsIgnoreCase("ie")) {
            capabilities.setBrowserName("internet explorer");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, true);
            capabilities.setCapability("ie.ensureCleanSession", true);
            capabilities.setCapability(InternetExplorerOptions.IE_OPTIONS, options);
        } else {
            throw new IllegalArgumentException("Invalid browser specified");
        }
        try {
            return new RemoteWebDriver(new URL(GRID_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid grid URL: " + GRID_URL, e);
        }
    }

    private static WebDriver createLocalDriver(String browser) {
        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", EnvHelper.getChromeDriverPath());

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", EnvHelper.getGeckoDriverPath());
            FirefoxOptions options = new FirefoxOptions();

            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", EnvHelper.getEdgeDriverPath());

            EdgeOptions options = new EdgeOptions();

            driver = new EdgeDriver(options);
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", EnvHelper.getIEDriverPath());

            InternetExplorerOptions options = new InternetExplorerOptions();

            driver = new InternetExplorerDriver(options);
        } else {
            throw new IllegalArgumentException("Invalid browser specified");
        }

        return driver;
    }
}