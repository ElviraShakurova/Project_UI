package tests.way2automation;

import helpers.EnvHelper;
import org.testng.annotations.BeforeMethod;
import tests.base.BaseTest;

public class Way2AutomationBaseTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() throws Throwable {
        super.beforeMethod();
        driver.get(EnvHelper.getBaseUrl());
    }
}