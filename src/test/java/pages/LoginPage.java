package pages;

import helpers.EnvHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "formly_1_input_username_0")
    private WebElement userNameDescriptionInput;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(css = "div[ng-if='Auth.error']")
    private WebElement errorAlert;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, EnvHelper.getExplicitWaitDuration());
    }

    @Step("Ввод логина в поле Username")
    public LoginPage setInputUserName(String userName) {
        userNameInput.sendKeys(userName);
        return this;
    }

    @Step("Ввод пароля в поле Password")
    public LoginPage setInputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Ввод логина в поле UsernameDescription")
    public LoginPage setInputUserNameDescriptionInput(String userNameDescription) {
        userNameDescriptionInput.sendKeys(userNameDescription);
        return this;
    }

    @Step("Ожидание появления поля Username")
    public LoginPage waitUserName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        return this;
    }

    @Step("Нажатие на кнопку Login")
    public RegistrationPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new RegistrationPage(driver);
    }

    @Step("Открытие новой вкладки с формой авторизации и переключение на нее")
    public void switchNewLoginTab(){
        String currentWindowHandle = driver.getWindowHandle();
        String newTabUrl =EnvHelper.getLoginUrl();
        ((JavascriptExecutor) driver).executeScript("window.open('" + newTabUrl + "','_blank');");
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Step("Проверка отображения сообщения об не успешной регистрации")
    public LoginPage assertErrorAlert(){
        assertTrue(errorAlert.isDisplayed());
        return this;
    }
}