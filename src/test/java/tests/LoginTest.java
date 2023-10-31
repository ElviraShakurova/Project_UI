package tests;

import helpers.EnvHelper;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProtractorAngularjsPage;
import pages.RegistrationPage;

public class LoginTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Авторизация")
    @Feature("Функция авторизации")
    @Story("Успешная авторизация")
    @Description("Проверка успешной авторизации")
    public void testLoginSuccessful() {
        MainPage mainPage = new MainPage(getDriver())
                .clickResourcesButton();
        ProtractorAngularjsPage protractorAngularjsPage = mainPage.clickPracticeSite2();
        LoginPage loginPage = protractorAngularjsPage.clickRegistrationButton();
        loginPage.switchNewLoginTab();
        LoginPage newTabLoginPage = new LoginPage(getDriver())
                .waitUserName()
                .setInputUserName(EnvHelper.getUserName())
                .setInputPassword(EnvHelper.getPassword())
                .setInputUserNameDescriptionInput(EnvHelper.getUserNameDescription());
        RegistrationPage registrationPage = loginPage.clickLoginButton()
                .verifyLoggedInPresent();
    }
}