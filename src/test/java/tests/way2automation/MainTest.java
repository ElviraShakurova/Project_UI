package tests.way2automation;

import io.qameta.allure.*;;
import pages.MainPage;
import org.testng.annotations.Test;

public class MainTest extends Way2AutomationBaseTest{

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты главной страницы")
    @Story("Проверка наличия элементов страницы")
    @Test
    public void verifyElementsMainPage() {
        MainPage mainPage = new MainPage(getDriver())
                .verifyContactHeaderPresent()
                .verifyHorizontalMenuPresent()
                .assertBlockCertification()
                .verifyFooterPresent();
    }

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты главной страницы")
    @Story("Проверка отображения главного меню в шапке")
    @Test
    public void verifyMainHeader() {
        MainPage mainPage = new MainPage(getDriver())
                .assertBlockCertification()
                .verifyHorizontalMenuPresent();
    }

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты главной страницы")
    @Feature("Проверка работы слайдера в блоке с курсами")
    @Test
    public void testSlideBlockCourses() {
        MainPage mainPage = new MainPage(getDriver())
                .scrollBlockCourses()
                .clickSlideButton()
                .assertSlide1IsPresent()
                .clickCloseButton()
                .clickSlideNextButton()
                .assertSlide3IsPresent();
    }

    @Severity(SeverityLevel.NORMAL)
    @Epic("Тесты главной страницы")
    @Story("Проверка наличия прокрутки на главной странице")
    @Test
    public void verifyScrollPresent() {
        MainPage mainPage = new MainPage(getDriver())
                .assertScrollPresent();
    }
}