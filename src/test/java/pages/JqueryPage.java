package pages;

import helpers.EnvHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class JqueryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(className = "fancybox-inner")
    private WebElement registrationForm;

    public JqueryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, EnvHelper.getExplicitWaitDuration());
    }

    @Step("Проверка отображения формы регистрации")
    public JqueryPage assertRegistrationForm() {
        wait.until(ExpectedConditions.visibilityOf(registrationForm));
        assertTrue(registrationForm.isDisplayed());
        return this;
    }
}