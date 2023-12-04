package tests.way2automation;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.JqueryPage;
import pages.MainPage;
import tests.base.BaseFactoryTest;
import tests.base.GridBaseTest;

import static java.sql.DriverManager.getDriver;

public class RegistrationForm1Test extends BaseFactoryTest {

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты формы регистрации")
    @Story("Проверка перехода с главной страницы по меню на страницу с формой регистрации 1")
    @Test
    public void testRegistrationForm1() {
        MainPage mainPage = new MainPage(driver)
                .clickResourcesButton();
        JqueryPage jqueryPage = mainPage.clickPracticeSite1()
                .assertRegistrationForm();
    }
}