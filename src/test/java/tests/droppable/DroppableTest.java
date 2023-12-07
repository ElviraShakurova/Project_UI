package tests.droppable;

import org.testng.annotations.Test;
import pages.DroppablePage;

public class DroppableTest extends DroppableBaseTest {

    @Test
    public void testDroppableElements(){
        DroppablePage droppablePage = new DroppablePage(getDriver())
                .clickAccept()
                .assertDragAndDropElements();
    }
}
