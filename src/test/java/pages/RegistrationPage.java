package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    private final WebDriver driver;

    @FindBy(linkText = "Logout")
    private WebElement loggedIn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка отображения сообщения об успешной регистрации")
    public RegistrationPage verifyLoggedInPresent() {
        assertTrue(loggedIn.isDisplayed());
        return this;
    }
}