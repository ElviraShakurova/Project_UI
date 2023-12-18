package pages;

import helpers.EnvHelper;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.junit.Assert.assertEquals;

public class AlertPhpPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "a[href='#example-1-tab-2']")
    private WebElement inputAlert;

    @FindBy(css = "iframe[src='alert/input-alert.html']")
    private WebElement frame;

    @FindBy(css = "button[onclick='myFunction()']")
    private WebElement inputBox;

    @FindBy(id = "demo")
    private WebElement setBox;

    public AlertPhpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, EnvHelper.getExplicitWaitDuration());
    }

    @Step("Нажатие на тоглл Input Alert")
    public AlertPhpPage clickInputAlert(){
        inputAlert.click();
        return this;
    }

    @Step("Нажатие на кнопку для вызова модального окна")
    public AlertPhpPage clickInputBox(){
        driver.switchTo().frame(frame);
        inputBox.click();
        return this;
    }

    @Step("Ввод кастомного текста в модальном окне")
    public AlertPhpPage setAlertInput(String alertText){
        Alert prompt = wait.until(alertIsPresent());
        prompt.sendKeys(alertText);
        prompt.accept();
        return this;
    }

    @Step("Проверка отображения корректного текста в модальном окне")
    public AlertPhpPage assertTextInSetBox(){
        String expectedText= String.format("Hello %s! How are you today?", EnvHelper.getInputTextInAlert());
        assertEquals(setBox.getText(), expectedText);
        return this;
    }
}
