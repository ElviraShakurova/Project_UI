package tests.alert;

import helpers.EnvHelper;
import org.testng.annotations.BeforeMethod;
import tests.base.BaseTest;

public class AlertPhpBaseTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod() throws Throwable {
        super.beforeMethod();
        driver.get(EnvHelper.getAlertsUrl());
    }
}
