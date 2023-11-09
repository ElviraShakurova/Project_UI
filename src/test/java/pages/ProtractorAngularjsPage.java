package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProtractorAngularjsPage {
    private final WebDriver driver;

    @FindBy(linkText = "Registration")
    private WebElement registrationButton;

    public ProtractorAngularjsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Прокрутка и нажатие на кнопку Registration")
    public LoginPage clickRegistrationButton() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", registrationButton);
        registrationButton.click();
        return new LoginPage(driver);
    }
}