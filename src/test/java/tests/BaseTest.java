package tests;

import helpers.EnvHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvHelper.getDriverPath()))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvHelper.getBrowserPath());
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(service, options);
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