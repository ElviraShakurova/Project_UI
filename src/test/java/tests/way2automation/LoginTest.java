package tests.way2automation;

import helpers.EnvHelper;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProtractorAngularjsPage;
import pages.RegistrationPage;
import tests.base.GridBaseTest;

public class LoginTest extends GridBaseTest {

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

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Авторизация")
    @Feature("Функция авторизации")
    @Story("Проверка отображения кнопки Login: кнопка не активна без ввода данных в поля Username, Password")
    public void testLoginButtonNotEnabled(){
        MainPage mainPage = new MainPage(getDriver())
                .clickResourcesButton();
        ProtractorAngularjsPage protractorAngularjsPage = mainPage.clickPracticeSite2();
        LoginPage loginPage = protractorAngularjsPage.clickRegistrationButton();
        loginPage.switchNewLoginTab();
        LoginPage newTabLoginPage = new LoginPage(getDriver())
                .waitUserName()
                .removeFocusUserNameInput()
                .removeFocusPasswordInput()
                .assertLoginButtonNotEnabled();
    }
}