package tests.basic_auth;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.AuthenticationPage;

public class BasicAuthTest extends BasicAuthBaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Feature("Базовая аутентификация")
    @Story("Успешная аутентификация пользователя")
    @Test
    public void testBasicAuthentication() {
        AuthenticationPage authenticationPage= new AuthenticationPage(driver)
                .clickDisplayImageButton()
                .assertImageSuccessfullyBathAuthentication();
    }
}