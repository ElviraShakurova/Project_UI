package tests.base;

import helpers.EnvHelper;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;

public class GridBaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        String hubUrl = "http://172.25.48.1:4444";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "100");
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("se:name", "My simple test");
        chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");

        driver = new RemoteWebDriver(new URI(hubUrl).toURL(), chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(EnvHelper.getImplicitWaitDuration());
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}