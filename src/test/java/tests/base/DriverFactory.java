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
        return useGrid ? createRemoteDriver(browser) : createLocalDriver(browser);
        }

    private static WebDriver createRemoteDriver(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser.toLowerCase()) {
            case "chrome":
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions());
                break;
            case "firefox":
                capabilities.setBrowserName("firefox");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
                break;
            case "edge":
                capabilities.setBrowserName("MicrosoftEdge");
                capabilities.setCapability(EdgeOptions.CAPABILITY, new EdgeOptions());
                break;
            case "ie":
                capabilities.setBrowserName("internet explorer");
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, true);
                capabilities.setCapability("ie.ensureCleanSession", true);
                capabilities.setCapability(InternetExplorerOptions.IE_OPTIONS, options);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified" + browser);
        }

        try {
            return new RemoteWebDriver(new URL(GRID_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid grid URL: " + GRID_URL, e);
        }
    }

    private static WebDriver createLocalDriver(String browser) {
        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", EnvHelper.getChromeDriverPath());
                return new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
            case "firefox":
                System.setProperty("webdriver.gecko.driver", EnvHelper.getGeckoDriverPath());
                return new FirefoxDriver(new FirefoxOptions());
            case "edge":
                System.setProperty("webdriver.edge.driver", EnvHelper.getEdgeDriverPath());
                return new EdgeDriver(new EdgeOptions());
            case "ie":
                System.setProperty("webdriver.ie.driver", EnvHelper.getIEDriverPath());
                return new InternetExplorerDriver(new InternetExplorerOptions());
            default:
                throw new IllegalArgumentException("Invalid browser specified" + browser);
        }
    }
}