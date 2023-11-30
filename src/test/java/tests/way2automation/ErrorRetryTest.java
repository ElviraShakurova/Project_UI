package tests.way2automation;

import helpers.EnvHelper;
import helpers.RetryAnalyzer;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProtractorAngularjsPage;
import pages.RegistrationPage;

public class ErrorRetryTest extends Way2AutomationBaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
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
                .setInputPassword(EnvHelper.getPassword());
        RegistrationPage registrationPage = loginPage.clickLoginButton()
                .verifyLoggedInPresent();
    }

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты главной страницы")
    @Feature("Проверка работы слайдера в блоке с курсами")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testSlideBlockCourses() {
        MainPage mainPage = new MainPage(getDriver())
                .clickCloseButton()
                .clickSlideButton()
                .assertSlide1IsPresent()
                .clickCloseButton()
                .clickSlideNextButton()
                .assertSlide3IsPresent();
    }

}
