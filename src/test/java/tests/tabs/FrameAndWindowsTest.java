package tests.tabs;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.FrameAndWindowsPage;

public class FrameAndWindowsTest extends FrameAndWindowsBaseTest{

    @Severity(SeverityLevel.NORMAL)
    @Feature("Функция открытия и переключения вкладок")
    @Story("Успешное открытие и перемещение по вкладкам")
    @Test
    public void testTabs(){
        FrameAndWindowsPage frameAndWindowsPage = new FrameAndWindowsPage(driver)
                .clickLinkOnFirstTab()
                .switchFromFirstTabToSecond()
                .clickLinkOnSecondTab()
                .assertCountTabs();
    }
}