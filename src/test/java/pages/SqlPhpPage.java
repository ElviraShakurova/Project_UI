package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class SqlPhpPage {
    private final WebDriver driver;

    @FindBy(css = "img[src='/images/logout.gif']")
    private WebElement logout;

    public SqlPhpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка отображения кнопки выхода")
    public SqlPhpPage assertLogoutButton(){
        assertTrue(logout.isDisplayed());
        return this;
    }
}