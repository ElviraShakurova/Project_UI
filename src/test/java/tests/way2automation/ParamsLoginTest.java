package tests.way2automation;

import helpers.EnvHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProtractorAngularjsPage;
import pages.RegistrationPage;

public class ParamsLoginTest extends Way2AutomationBaseTest {
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {EnvHelper.getUserName(), EnvHelper.getPassword()},
                {EnvHelper.getUserName(), EnvHelper.getInvalidPassword()},
                {EnvHelper.getInvalidUsername(), EnvHelper.getPassword()},
        };
    }

    @Severity(SeverityLevel.NORMAL)
    @Epic("Авторизация")
    @Feature("Функция авторизации")
    @Test(dataProvider = "loginData")
    public void testLoginWithParams (String username, String password){
        MainPage mainPage = new MainPage(getDriver())
                .clickResourcesButton();
        ProtractorAngularjsPage protractorAngularjsPage = mainPage.clickPracticeSite2();
        LoginPage loginPage = protractorAngularjsPage.clickRegistrationButton();
        loginPage.switchNewLoginTab();
        LoginPage newTabLoginPage = new LoginPage(getDriver())
                .waitUserName()
                .setInputUserName(username)
                .setInputPassword(password)
                .setInputUserNameDescriptionInput(EnvHelper.getUserNameDescription());
        RegistrationPage registrationPage = loginPage.clickLoginButton();
        if (username.equals(EnvHelper.getUserName()) && password.equals(EnvHelper.getPassword())) {
                    registrationPage.verifyLoggedInPresent();
        } else {
            loginPage.assertErrorAlert();
        }
    }
}