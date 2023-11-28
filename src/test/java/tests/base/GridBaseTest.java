package tests.base;

import helpers.EnvHelper;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL(hubUrl), firefoxOptions);
        } else {
            throw new IllegalArgumentException("Invalid browser specified");
        }
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