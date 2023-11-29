package tests.base;

import helpers.EnvHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class GridBaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome")String browser) throws MalformedURLException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        String hubUrl = "http://172.25.48.1:4444";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")) {
            capabilities.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")){
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
        } else {
            throw new IllegalArgumentException("Invalid browser specified");
        }
        driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(EnvHelper.getImplicitWaitDuration());
        driver.get(EnvHelper.getBaseUrl());
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}