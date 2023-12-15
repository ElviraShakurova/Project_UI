package tests.alert;

import helpers.EnvHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.AlertPhpPage;

public class AlertPhpTest extends AlertPhpBaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Feature("Функция ввода текста в модальном окне")
    @Story("Успешное переключение и ввод текста в модальном окне")
    @Test
    public void testAlerts(){
        AlertPhpPage alertPhpPage = new AlertPhpPage(driver)
                .clickInputAlert()
                .clickInputBox()
                .setAlertInput(EnvHelper.getInputTextInAlert())
                .assertTextInSetBox();
    }
}
