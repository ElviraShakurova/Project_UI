package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.JqueryPage;
import pages.MainPage;

public class RegistrationForm1Test extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты формы регистрации")
    @Story("Проверка перехода с главной страницы по меню на страницу с формой регистрации 1")
    @Test
    public void testRegistrationForm1() {
        MainPage mainPage = new MainPage(getDriver())
                .clickResourcesButton();
        JqueryPage jqueryPage = mainPage.clickPracticeSite1()
                .assertRegistrationForm();
    }
}