package pages;

import helpers.EnvHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "li.elementor-icon-list-item")
    private WebElement contactHeader;

    @FindBy(id = "ast-hf-menu-1")
    private WebElement horizontalMenu;

    @FindBy(css = ".elementor-widget-wrap")
    private WebElement blockCertification;

    @FindBy(css = ".pp-slider-arrow.swiper-button-prev")
    private WebElement slideButton;

    @FindBy(css = "h2.elementor-heading-title")
    private WebElement footer;

    @FindBy(id = "menu-item-27617")
    private WebElement resourcesButton;

    @FindBy(className = "elementor-image-box-description")
    private WebElement blockCourses;

    @FindBy(linkText = "Practice Site 1")
    private WebElement practiceSite1Button;

    @FindBy(linkText = "Practice Site 2")
    private WebElement practiceSite2Button;

    @FindBy(css = "div.swiper-slide[data-swiper-slide-index='1']")
    private WebElement slide1;

    @FindBy(css = "div.pp-slider-arrow.swiper-button-next")
    private WebElement slideNextButton;

    @FindBy(css = "div.swiper-slide[data-swiper-slide-index='3']")
    private WebElement slide3;

    @FindBy(className = "dialog-close-button")
    private WebElement closeButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, EnvHelper.getImplicitWaitDuration());
    }

    @Step("Проверка отображения шапки сайта с реквизитами для связи")
    public MainPage verifyContactHeaderPresent() {
        assertTrue(contactHeader.isDisplayed());
        return this;
    }

    @Step("Проверка отображения горизонтального меню")
    public MainPage verifyHorizontalMenuPresent() {
        assertTrue(horizontalMenu.isDisplayed());
        return this;
    }

    @Step("Проверка отображения блока с сертификацией")
    public MainPage assertBlockCertification() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", blockCertification);
        assertTrue(blockCertification.isDisplayed());
        return this;
    }

    @Step("Нажатие на кнопку закрытия всплывающего окна")
    public MainPage clickCloseButton(){
        wait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();
        return this;
    }

    @Step("Прокрутка к блоку с курсами")
    public MainPage scrollBlockCourses(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", blockCourses);
        return this;
    }

    @Step("Нажатие на кнопку слайдера, для пролистывания влево")
    public MainPage clickSlideButton() {
        slideButton.click();
        return this;
    }

    @Step("Проверка отображения футера")
    public MainPage verifyFooterPresent() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", footer);
        assertTrue(footer.isDisplayed());
        return this;
    }

    @Step("Нажатие на кнопку Resources")
    public MainPage clickResourcesButton() {
        resourcesButton.click();
        return this;
    }

    @Step("Нажатие на кнопку Practice Site 1")
    public JqueryPage clickPracticeSite1() {
        practiceSite1Button.click();
        return new JqueryPage(driver);
    }

    @Step("Нажатие на кнопку Practice Site 2")
    public ProtractorAngularjsPage clickPracticeSite2() {
        practiceSite2Button.click();
        return new ProtractorAngularjsPage(driver);
    }

    @Step("Проверка отображения первого слайда")
    public MainPage assertSlide1IsPresent() {
        slide1.isDisplayed();
        return this;
    }

    @Step("Нажатие на кнопку слайдера, для пролистывания вправо")
    public MainPage clickSlideNextButton() {
        wait.until(ExpectedConditions.visibilityOf(slideNextButton));
        slideNextButton.click();
        return this;
    }

    @Step("Проверка отображения третьего слайда")
    public MainPage assertSlide3IsPresent() {
        slide3.isDisplayed();
        return this;
    }
}