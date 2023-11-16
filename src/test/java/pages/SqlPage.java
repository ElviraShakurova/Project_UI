package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SqlPage {
    private final WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "psw")
    private WebElement passwordInput;

    @FindBy(name = "subm1")
    private WebElement entryButton;

    public SqlPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод логина в поле Логин")
    public SqlPage setInputLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Ввод пароля в поле Пароль")
    public SqlPage setInputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажатие на кнопку Вход")
    public SqlPhpPage clickEntryButton() {
        entryButton.click();
        return new SqlPhpPage(driver);
    }
}