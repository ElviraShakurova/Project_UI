package tests;

import helpers.CookiesHelper;
import helpers.EnvHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class LoginSqlTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvHelper.getDriverPath()))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvHelper.getBrowserPath());
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(EnvHelper.getImplicitWaitDuration());
        driver.get(EnvHelper.getSqlUrl());
    }

    @Test
    public void testLoginSql() {
        Set<Cookie> cookies = CookiesHelper.readCookiesFromFile("cookies.txt", driver);
        if (!cookies.isEmpty()) {
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
        } else {
            driver.findElement(By.name("login")).sendKeys(EnvHelper.getLoginSql());
            driver.findElement(By.name("psw")).sendKeys(EnvHelper.getPasswordSql());
            driver.findElement(By.name("subm1")).click();
            driver.get(EnvHelper.getSqlPhpUrl());
            assertTrue(driver.findElement(By.cssSelector("img[src='/images/logout.gif']")).isDisplayed());
            cookies = driver.manage().getCookies();
            CookiesHelper.saveCookiesToFile(cookies, "cookies.txt");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
