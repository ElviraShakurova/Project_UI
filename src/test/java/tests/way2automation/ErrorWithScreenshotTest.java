package tests.way2automation;

import helpers.EnvHelper;
import helpers.ScreenshotHelper;
import io.qameta.allure.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProtractorAngularjsPage;
import pages.RegistrationPage;

public class ErrorWithScreenshotTest extends Way2AutomationBaseTest {

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
                .setInputPassword(EnvHelper.getPassword());
        RegistrationPage registrationPage = loginPage.clickLoginButton()
                .verifyLoggedInPresent();
    }

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты главной страницы")
    @Feature("Проверка работы слайдера в блоке с курсами")
    @Test
    public void testSlideBlockCourses() {
        MainPage mainPage = new MainPage(getDriver())
                .clickCloseButton()
                .clickSlideButton()
                .assertSlide1IsPresent()
                .clickCloseButton()
                .clickSlideNextButton()
                .assertSlide3IsPresent();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotName = result.getName();
            ScreenshotHelper.takeScreenshot(getDriver(), screenshotName);
        }
    }
}