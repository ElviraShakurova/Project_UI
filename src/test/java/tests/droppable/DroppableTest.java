package tests.droppable;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.DroppablePage;

public class DroppableTest extends DroppableBaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Feature("Функция перемещения элементов")
    @Story("Успешное перетаскивание элемента в принимающий")
    @Test
    public void testDroppableElements(){
        DroppablePage droppablePage = new DroppablePage(getDriver())
                .clickAccept()
                .assertDragAndDropElements();
    }
}