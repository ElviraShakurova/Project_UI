package tests.sql;

import helpers.CookiesHelper;
import helpers.EnvHelper;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pages.SqlPage;
import pages.SqlPhpPage;

import java.util.Set;

public class LoginSqlTest extends SqlBaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Epic("Авторизация")
    @Feature("Функция авторизации")
    @Story("Успешная авторизация")
    @Test
    public void testLoginSql() {
        Set<Cookie> cookies = CookiesHelper.readCookiesFromFile("cookies.txt", driver);
        if (!cookies.isEmpty()) {
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
        } else {
            SqlPage sqlPage = new SqlPage(getDriver())
                    .setInputLogin(EnvHelper.getLoginSql())
                    .setInputPassword(EnvHelper.getPasswordSql());
            SqlPhpPage sqlPhpPage = sqlPage.clickEntryButton()
                    .assertLogoutButton();
            cookies = driver.manage().getCookies();
            CookiesHelper.saveCookiesToFile(cookies, "cookies.txt");
        }
    }
}