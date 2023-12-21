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

public class AuthenticationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "displayImage")
    private WebElement displayImageButton;

    @FindBy(id = "downloadImg")
    private WebElement imageSuccessfullyAuthentication;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, EnvHelper.getExplicitWaitDuration());
    }

    @Step("Нажатие на кнопку Display Image")
    public AuthenticationPage clickDisplayImageButton(){
        displayImageButton.click();
        return this;
    }

    @Step("Проверка отображения изображения об успешной авторизации")
    public AuthenticationPage assertImageSuccessfullyBathAuthentication(){
        wait.until(ExpectedConditions.visibilityOf(imageSuccessfullyAuthentication));
        assertTrue(imageSuccessfullyAuthentication.isDisplayed());
        return this;
    }
}