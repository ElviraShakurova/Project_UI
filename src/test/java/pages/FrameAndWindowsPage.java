package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class FrameAndWindowsPage {
    private final WebDriver driver;

    @FindBy(css = "a[href='#']")
    private WebElement link;

    @FindBy(css = "iframe[src='frames-windows/defult1.html']")
    private WebElement frame;

    public FrameAndWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие на ссылку в первой вкладке")
    public FrameAndWindowsPage clickLinkOnFirstTab(){
        driver.switchTo().frame(frame);
        Actions builder = new Actions(driver);
        link.click();
        return this;
    }

    @Step("Переключение на вторую вкладку")
    public FrameAndWindowsPage switchFromFirstTabToSecond() {
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return this;
    }

    @Step("Нажатие на ссылку во второй вкладке")
    public FrameAndWindowsPage clickLinkOnSecondTab(){
        link.click();
        return this;
    }

    @Step("Проверка открытия третьей вкладки")
    public FrameAndWindowsPage assertCountTabs(){
        ArrayList<String> tabsCount = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertEquals(tabsCount.size(), 3);
        return this;
    }
}