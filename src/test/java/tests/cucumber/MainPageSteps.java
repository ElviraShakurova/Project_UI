package tests.cucumber;
import helpers.EnvHelper;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import pages.MainPage;
import tests.base.BaseTest;
import tests.way2automation.MainTest;
import tests.way2automation.Way2AutomationBaseTest;

import java.io.File;

import static java.sql.DriverManager.getDriver;


public class MainPageSteps extends BaseTest {
    private MainPage mainPage;
    private WebDriver driver;

    @Given("Я нахожусь на главной странице")
    public void я_нахожусь_на_главной_странице() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvHelper.getDriverPath()))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvHelper.getBrowserPath());
        driver = new ChromeDriver(service, options);
        driver.get("https://www.way2automation.com/");
        mainPage = new MainPage(driver);
    }

    @Then("Проверяю наличие заголовков контактов")
    public void проверяю_наличие_заголовков_контактов() {
        mainPage.verifyContactHeaderPresent();
    }

    @Then("Проверяю наличие горизонтального меню")
    public void проверяю_наличие_горизонтального_меню() {
        mainPage.verifyHorizontalMenuPresent();
    }

    @Then("Прокручиваю страницу до блока сертификации")
    public void прокручиваю_страницу_до_блока_сертификации(){
        mainPage.assertBlockCertification();
    }

    @Then("Проверяю наличие блока с сертификацией")
    public void проверяю_наличие_блока_с_сертификацией(){
        mainPage.assertBlockCertification();
    }

    @And("Проверяю наличие подвала")
    public void проверяю_наличие_подвала(){
        mainPage.verifyFooterPresent();
    }

    @When("Прокручиваю блок с курсами")
    public void прокручиваю_блок_с_курсами(){
        mainPage.scrollBlockCourses();
    }

    @And("Нажимаю левую кнопку слайдера")
    public void нажимаю_левую_кнопку_слайдера(){
        mainPage.clickSlideButton();
    }

    @Then("Проверяю наличие первого слайда")
    public void проверяю_наличие_первого_слайда(){
        mainPage.assertSlide1IsPresent();
    }

    @And("Нажимаю на кнопку закрытия всплывающего окна")
    public void нажимаю_на_кнопку_закрытия_всплывающего_окна(){
        mainPage.clickCloseButton();
    }

    @And("Нажимаю на правую кнопку слайдера")
    public void нажимаю_на_правую_кнопку_слайдера(){
        mainPage.clickSlideNextButton();
    }

    @Then("Проверяю наличие третьего слайда")
    public void проверяю_наличие_третьего_слайда(){
        mainPage.assertSlide3IsPresent();
    }

    @Then("Проверяю наличие прокрутки")
    public void проверяю_наличие_прокрутки(){
        mainPage.assertScrollPresent();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}