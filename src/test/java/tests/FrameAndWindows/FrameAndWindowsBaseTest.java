package tests.FrameAndWindows;

import helpers.EnvHelper;
import org.testng.annotations.BeforeMethod;
import tests.base.BaseTest;

public class FrameAndWindowsBaseTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod() throws Throwable {
        super.beforeMethod();
        driver.get(EnvHelper.getFrameAndWindows());
    }
}
