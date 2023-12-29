package tests.basic_auth;

import helpers.EnvHelper;
import org.testng.annotations.BeforeMethod;
import tests.base.BaseTest;

public class BasicAuthBaseTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod() throws Throwable {
        super.beforeMethod();
        String baseUrl = "http://" + EnvHelper.getBasicUsername() + ":" + EnvHelper.getBasicPassword() + "@" + EnvHelper.getBasicAuthUrl();
        driver.get(baseUrl);
    }
}
