package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class DroppablePage {
    private final WebDriver driver;

    @FindBy(css = "a[href='#example-1-tab-2']")
    private WebElement accept;

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "droppable")
    private WebElement droppableElement;

    @FindBy(css = "iframe[src='droppable/default2.html']")
    private WebElement frame;

    public DroppablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DroppablePage clickAccept(){
        accept.click();
        return this;
    }

    @Step("Проверка о том, что текст принимающего элемента изменился после перетаскивания элемента")
    public DroppablePage assertDragAndDropElements(){
        driver.switchTo().frame(frame);
        Actions builder = new Actions(driver);
        builder.dragAndDrop(draggableElement, droppableElement).perform();
        assertEquals("Dropped!", droppableElement.getText());
        return this;
    }
}